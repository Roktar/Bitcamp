package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.support.WebApplicationContextUtils;
import bitcamp.java106.pms.web.RequestMapping;

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
        response.setContentType("text/html;charset=UTF-8");
        // 사용자 요청 찾기
        String servletPath = request.getServletPath().replace(".do", "");
        int index = servletPath.lastIndexOf('/'); //   /board /add 
        String objName = servletPath.substring(0, index); // /board/add가 올 경우, 앞의 /board를 추출
        String handlerPath = servletPath.substring(index); // board/add가 올 경우, 뒤의 /add를 추출
        
        try {
            // 사용자 요청에 맞는 컨트롤러 찾기
            Object pg = iocContainer.getBean(objName);
            //클라이언트 요청에 맞는 메소드를 찾기
            Method requestHandler = findRequestHandler(pg, handlerPath);
            
            if(requestHandler == null)
                throw new Exception("요청을 처리할 핸들러가 없습니다.");
            
            // 컨트롤러 매핑
            String viewUrl = (String)requestHandler.invoke(pg, request, response);
            
            if(viewUrl.startsWith("redirect:"))
                response.sendRedirect(viewUrl.substring(9));
            else 
                request.getRequestDispatcher(viewUrl).include(request, response);
        } catch(Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류발생");
        }
    }
    
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
