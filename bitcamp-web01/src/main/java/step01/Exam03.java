package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//Servlet 생성
// - Exam02에 이어서..
// - 자바에서는 GenericServlet이라는 추상클래스를 제공한다.
@WebServlet("/step01/exam03")
public class Exam03 extends javax.servlet.GenericServlet {
    private static final long serialVersionUID = 1L;
    ServletConfig config;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("exam03.service()");
        res.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = res.getWriter();
        out.println("exam03 커맨드에 맞는 작업");
    }
}
