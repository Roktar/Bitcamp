package step09.ex2;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class Listener2 implements ServletRequestListener{
    
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        System.out.printf("Listener1.Initialized : %s\n", new Date());
        System.out.printf("requested URL : %s\n", req.getServletPath());
        System.out.printf("CLient IP : %s\n", req.getRemoteAddr());
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 서블릿 컨테이너가 종료될 때 호출
        System.out.printf("Listener1.Destroyed : %s\n", new Date());
    }
}
