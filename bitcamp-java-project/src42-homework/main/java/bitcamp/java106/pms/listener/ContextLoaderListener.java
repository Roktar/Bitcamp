package bitcamp.java106.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

// 서블릿 컨테이너가 시작될 때 스프링 IoC 컨테이너를 준비한다.
// => 기존의 InitServlet 역할을 대체한다.
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    
    static ApplicationContext container;
    
/*    public static ApplicationContext getApplicationContext() {
        return container;
    }*/
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String configCName = ctx.getInitParameter("contextConfigLocation");
        // 서블릿 컨테이너가 시작되면 스프링 IoC 컨테이너를 준비한다. 
        try {
        ApplicationContext iocContainer = new AnnotationConfigApplicationContext(Class.forName(configCName));
//        container = iocContainer;
        WebApplicationContextUtils.containers.put(sce.getServletContext(), iocContainer);
        // 컨테이너에 하나의 컨테이너만 들어가있다. ==> 하나의 컨테이너에는 여러 개의 객체가 보관되어 있다.
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
