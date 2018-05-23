package step10.ex4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex4/exam04")
public class Exam04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String name =  URLDecoder.decode((String) session.getAttribute("name"), "UTF-8");
        int age = (int) session.getAttribute("age");
        String tel = request.getParameter("tel");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> 서블릿 데이터 공유 테스트 </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>페이지4</h1>");
        out.printf("이름:%s\n", name);
        out.printf("나이:%d\n", age);
        out.printf("전화:%s\n", tel);
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
