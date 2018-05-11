package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 데이터 입력받기
@WebServlet("/step03/exam03")
public class Exam03 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        
        res.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("이름 : %s\n", name);
        out.printf("나이 : %d\n", age);
        
    }
}
