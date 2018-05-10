package step01;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

// 목적
// - 서블릿 클래스가 공통으로 구현해야할 메소드를 미리 준비한다.
// - 개발자가 관심을 갖지않는 메소드는 여기서 미리 준비해둔다.
// - 실제 작업을 할 서블릿클래스에서는 전부를 오버라이딩할 필요가 없어지기때문에 간결해진다.

public abstract class GenericServlet implements Servlet{
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
}
// 추상클래스로 지정함으로 자식클래스에게 service 함수를 구현하도록 넘겼다.
// 여기서는 service를 구현하지 않아도 된다.
