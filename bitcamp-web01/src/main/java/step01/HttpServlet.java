package step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 목적은 서브클래스들에게 공통 기능을 상속해주려함이기때문에
// 해당 클래스 독립적으로 사용할 수 없도록 추상클래스로 만든다.
public abstract class HttpServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 인자로 넘어오는 것은 실제로 HTTP 프로토콜을 다룰 수 있는 객체.
        // ServletRequest 대신 그 자식 객체인 HttpServletRequest가 인자로 넘어온다.
        
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
    
        this.service(httpRequest, httpResponse);
    }
    
    public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException  {
        // 인자로 넘어오는 것은 실제로 HTTP 프로토콜을 다룰 수 있는 객체.
        // ServletRequest 대신 그 자식 객체인 HttpServletRequest가 인자로 넘어온다.
        String command = req.getMethod();
        
        switch(command) {
            case "GET" : doGet(req, res); break; 
            case "POST" : doPost(req, res); break; 
            case "HEAD" : doHead(req, res); break; 
            default :
                throw new ServletException("명령 처리 불가");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("HTTP Server의 get");
    }    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("HTTP Server의 Post");
    }    
    
    protected void doHead(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("HTTP Server의 Head");
    }
}
