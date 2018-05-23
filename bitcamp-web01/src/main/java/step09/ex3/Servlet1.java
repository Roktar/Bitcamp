package step09.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step09/ex3/servlet1")
public class Servlet1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        ServletContext ctx = this.getServletContext();
        PrintWriter out = response.getWriter();

        out.printf("p1=%s\n", ctx.getInitParameter("p1"));
        out.printf("p2=%s\n", ctx.getInitParameter("p2"));
    }
}
