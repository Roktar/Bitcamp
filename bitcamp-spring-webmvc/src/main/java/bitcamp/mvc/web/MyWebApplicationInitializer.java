package bitcamp.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("-------- MyWebApplicationInitializer.onStatup()");
        // 웹 어플리케이션 실행 시 이 메소드는 자동으로 호출된다. ==> 서블릿 컨테이너에 의해서.
        // 순서
        // 1. spring-web.jar 파일에서 /META-INF/services/javax.servlet.ServletContainerInitializer 파일을 찾는다.
        // 2. 그 파일에서 해당 인터페이스를 구현한 구현체 클래스의 정보를 찾아낸 후 호출한다.
        // 3. SpringServletCOntainerInitializer.onStartup()호출
        // 4. WebApplicationInitializer.onStartup() 호출
        // 5. MyWebApplicationInitializer.onStartup() 호출
        
        // 프론트 컨트롤러 등록
        
        // 1. 프론트컨트롤러가 사용할 SpringIoc컨테이너생성
        AnnotationConfigWebApplicationContext iocContainer = 
                new AnnotationConfigWebApplicationContext();
        iocContainer.register(AppConfig.class);
        iocContainer.refresh();
        
        // 2. 프론트 컨트롤러 생성
        DispatcherServlet mvcDispatcher = new DispatcherServlet(iocContainer);
        
        // 3. 프론트 컨트롤러 등록
        // addServlet의 반환값 : 서블릿 url 패턴 등을 설정할 때 사용할 도구
        Dynamic registration =  servletContext.addServlet("mvc", mvcDispatcher);
        
        // 4. 매핑
        registration.setLoadOnStartup(1); // load-on-startup 속성
        registration.addMapping("/mvc"); // servlet-mapping 속성
    }
}
