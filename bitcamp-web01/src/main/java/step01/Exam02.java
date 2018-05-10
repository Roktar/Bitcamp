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
// - 추상클래스 상속으로 Servlet 인터페이스를 간접구현.
@WebServlet("/step01/exam02")
public class Exam02 extends GenericServlet {
    ServletConfig config;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("exam02.service()");
        res.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = res.getWriter();
        out.println("exam02 커맨드에 맞는 작업");
    }
}
