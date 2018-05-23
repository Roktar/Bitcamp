package step08.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
@SuppressWarnings("serial")
@WebServlet("/step08/ex2/exam02")
public class Exam02 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        
        String op = req.getParameter("op");
        if(!op.equals("+")) {
            RequestDispatcher rd = req.getRequestDispatcher("/step08/ex2/exam03");
            rd.forward(req, res);
            return ;
        }
        
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        
        out.println("<!DOCTYPE HTML> ");
        out.println("<html> ");
        out.println("<head> ");
        out.println("<meta charset='UTF-8'> ");
        out.println("<title> </title> ");
        out.println("</head> ");
        out.println("<body> ");
        out.println("<h1>exam02</h1>");
        out.printf("<p>%d + %d = %d</p> ", a, b, a + b);
        out.println("</body> ");
        out.println("</html> ");
    }
}
