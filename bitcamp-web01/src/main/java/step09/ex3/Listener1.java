package step09.ex3;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener1 implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        System.out.printf("step09.ex3.Listener1 => %s, %s\n", ctx.getInitParameter("p1"), ctx.getInitParameter("p2"));
    }
}
