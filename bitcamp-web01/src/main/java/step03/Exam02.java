package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 클라이언트로 출력하기 - 한글 깨짐 현상 처리
@WebServlet("/step03/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("step03.Exam01.service()");
        out.println("한-글");
    }
}
