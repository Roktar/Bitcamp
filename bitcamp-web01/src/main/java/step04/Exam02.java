package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

// 요청 방식 알아내기
@WebServlet("/step04/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        HttpServletRequest request = (HttpServletRequest)req;
        
        req.setCharacterEncoding("UTF-8");
        
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("요청방식=%s\n", request.getMethod());
        out.printf("name=%s\n", name);
        out.printf("age=%d", age);
    }
}
