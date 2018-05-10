package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//Servlet 생성
@WebServlet("/step01/exam01")
public class Exam01 implements Servlet {
    ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("exam01.init()");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("exam01.service()");
        res.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = res.getWriter();
        out.println("exam01 커맨드에 맞는 작업");
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return "Exam01 Servlet";
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("exam01.destroy()");
    }
}
