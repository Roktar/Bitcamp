package step09.ex2;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener1 implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 서블릿 컨테이너가 시작될 때 호출
        System.out.printf("Listener1.Initialized : %s\n", new Date());
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 서블릿 컨테이너가 종료될 때 호출
        System.out.printf("Listener1.Destroyed : %s\n", new Date());
    }
}
