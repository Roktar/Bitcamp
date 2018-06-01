package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.support.WebApplicationContextUtils;
import bitcamp.java106.pms.web.RequestMapping;
import bitcamp.java106.pms.web.RequestParam;

@SuppressWarnings("serial")
@Component("*.do")
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;
    
    @Override
    public void init() throws ServletException {
        try {
            iocContainer = new ClassPathXmlApplicationContext(this.getServletConfig().getInitParameter("contextConfigLocation"));
            
            WebApplicationContextUtils.containers.put(this.getServletContext(), iocContainer);
            
            String[] beanNames = iocContainer.getBeanDefinitionNames();
            
            for(String name : beanNames)
                System.out.println(name);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 필터서블릿에서 해도 된다.
        response.setContentType("text/html;charset=UTF-8");
        // 사용자 요청 찾기
        String servletPath = request.getServletPath().replace(".do", "");
        int index = servletPath.lastIndexOf('/');
        String objName = servletPath.substring(0, index); // /board/add가 올 경우, 앞의 /board를 추출
        String handlerPath = servletPath.substring(index); // board/add가 올 경우, 뒤의 /add를 추출
        
        try {
            // src 48 - 사용자 요청에 맞는 컨트롤러 찾기
            Object pg = iocContainer.getBean(objName);
            // src 47, 48 - 클라이언트 요청에 맞는 메소드를 찾기
            Method requestHandler = findRequestHandler(pg, handlerPath);
            
            if(requestHandler == null)
                throw new Exception("요청을 처리할 핸들러가 없습니다.");
            
            // src 49 - 요청핸들러가 반환할 값을 담을 공간 준비
            HashMap<String, Object> resultMap = new HashMap<>();
            
            // src 49 - 요청 핸들러 파라미터값 준비
            Object[] paramValues = prepareParamValues(requestHandler, resultMap, request, response);
            System.out.println("------ 파라미터 목록 ------");
            for(Object val : paramValues)
                System.out.println(val.getClass().getName());
            
            // 컨트롤러 매핑, 메소드 실행 완료 후 이동할 페이지의 정보를 가지는 변수.
            String viewUrl = (String)requestHandler.invoke(pg, paramValues);
            System.out.println("귀환페이지 : " + viewUrl);
            
            // src 49 - 작업결과인 resultMap을 JSP가 사용할 수 있도록 저장소에 옮겨두기
            Set<String> keySet = resultMap.keySet();
            
            // Map에 등록된 키목록 추출
            System.out.println("------키목록------");
            for(String key : keySet) {
                System.out.println("key : " + key);
                request.setAttribute(key, resultMap.get(key));
            }
            
            if(viewUrl.startsWith("redirect:"))
                response.sendRedirect(viewUrl.substring(9));
            else 
                request.getRequestDispatcher(viewUrl).include(request, response);
        } catch(Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류발생");
        }
    }

    // src49
    private Object[] prepareParamValues(Method requestHandler, HashMap<String, Object> resultMap, HttpServletRequest request, HttpServletResponse response) {
        // 파라미터 정보를 넣어둘 저장소 준비
        ArrayList<Object> paramValues = new ArrayList<>();
        // 메소드의 파라미터정보 추출
        Parameter[] params = requestHandler.getParameters();
        
        System.out.println("준비할 메소드 : " + requestHandler.getName());
        
        // 각 파라미터의 타입에 맞는 값을 준비
        for(Parameter p : params) {
            if(p.getType() == Map.class)
                paramValues.add(resultMap);
            else if(p.getType() == HttpServletRequest.class)
                paramValues.add(request);
            else if(p.getType() == HttpServletResponse.class)
                paramValues.add(response);
            else if(p.getType() == HttpSession.class)
                paramValues.add(request.getSession());
            else if( isPrimitiveType(p.getType()) )// 기본타입에 대한 처리
                paramValues.add( getRequestParamValue(p, request) );
            else // 사용자 정의 타입에 대한 처리
                paramValues.add( getValueObject(p, request) );
        }
        return paramValues.toArray();
    }

//----------------------------- 사용자 정의 타입을 만들 때 사용되는 메소드 ---------------------------------------------
    private Object getValueObject(Parameter p, HttpServletRequest request) {
        Class<?> clazz = p.getType();
        
        try {
            Constructor<?> defaultConstrctor = clazz.getConstructor(); // 생성자
            Object valueObject = defaultConstrctor.newInstance(); // 객체 생성
            
            System.out.println(clazz.getClass().getName() + " 형식 객체 생성");
            
            Method[] methods = clazz.getMethods();
            
            System.out.println("메소드목록 생성");

            for(Method m : methods) {
                if(!m.getName().startsWith("set")) continue;
                String propName = getPropertyName(m.getName());
                String propValue = request.getParameter(propName);
                
                System.out.println("속성 : " + propName);
                
                // 리퀘스트 저장소에서 해당 프로퍼티의 값이 없는 경우 패스
                if(propValue == null) 
                    continue;
                
                // setter의 인자 형식을 찾는다.
                Class<?> setterParamType = m.getParameterTypes()[0];

                // Setter 메소드의 매개변수를 조사하여 기본형(+String)이 아닌 경우 작업하지않는다.
                if(!isPrimitiveType(setterParamType)) 
                    continue;
                
                // 찾은 setter를 실행하여 값을 해당 객체에 저장시킨다.
                m.invoke(valueObject, toPrimitiveValue(propValue, setterParamType));
            }
            System.out.println("생성된 객체 반환");
            return valueObject;
        } catch(Exception e) { }
        return null;
    }
    
    // setter의 이름을 이용하여 프로퍼티명 생성
    // ex) setTitle ==> title
    private String getPropertyName(String name) { 
        //setFirstName
        return name.substring(3, 4).toLowerCase() + name.substring(4);
    } // request.getParameter( getPropertyName(name ) ); 에서 name을 만드는 것이라고 생각하면 된다.
//---------------------------------------------------------------------------------------------------------------------

//------------------------------- Request 저장소에 있는 값을 꺼내는 메소드(@RequestParam)------------------------
    private Object getRequestParamValue(Parameter p, ServletRequest request) {
        RequestParam anno = p.getAnnotation(RequestParam.class);
        String paramName = anno.value(); // extract keyname
        String val = request.getParameter(paramName);
        
        if(val == null)
            return null;
        
        return toPrimitiveValue(val, p.getType());
    }

    private Boolean isPrimitiveType(Class<?> type) {
        if(type == byte.class ||type == short.class ||type == int.class || type == long.class || type == float.class || type == double.class || type == char.class || type == boolean.class || type == String.class || type == java.sql.Date.class)
            return true;
        return false;
    }
    
    private Object toPrimitiveValue(String val, Class<?> type) {
        if(type == byte.class) return Byte.parseByte(val);
        if(type == short.class) return Short.parseShort(val);
        if(type == int.class) return Integer.parseInt(val);
        if(type == long.class) return Long.parseLong(val);
        if(type == float.class) return Float.parseFloat(val);
        if(type == double.class) return Double.parseDouble(val);
        if(type == char.class) return val.charAt(0);
        if(type == boolean.class) return Boolean.parseBoolean(val);
        if(type == java.sql.Date.class) return Date.valueOf(val);
        return val;
    }
//---------------------------------------------------------------------------------------------------------------------    
    
    private Method findRequestHandler(Object pg, String handlerPath) throws Exception {
        Class<?> clazz = pg.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        
        for(Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if(anno != null && anno.value().equalsIgnoreCase(handlerPath))
                return m;
        }
        return null;
    }
}
