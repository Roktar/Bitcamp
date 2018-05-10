package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 서블릿을 서블릿 컨테이너에 배치 - 어노테이션으로 설정
@WebServlet(urlPatterns= {"/step02/exam01", "/step02/Exam01"})
public class Exam01 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = res.getWriter();
        out.println("step02.exam01.service()");
    }
}
