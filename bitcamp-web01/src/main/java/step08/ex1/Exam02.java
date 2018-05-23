package step08.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Refresh - 자동으로 페이지를 이동 - 응답헤더에 추가하는 방법
@SuppressWarnings("serial")
@WebServlet("/step08/ex1/exam02")
public class Exam02 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        
        res.setHeader("Refresh", "3;url=http://www.daum.net");
        out.println("<!DOCTYPE HTML> ");
        out.println("<html> ");
        out.println("<head> ");
        out.println("<meta charset='UTF-8'> ");
        out.println("<title> </title> ");
        out.println("</head> ");
        out.println("<body> ");
        out.println("<h1>exam01</h1> ");
        out.println("<p>3초 후에 다음 웹사이트를 요청한다.</p> ");
        out.println("</body> ");
        out.println("</html> ");
    }
}
