package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      String title = (String) request.getAttribute("title");
      Exception e = (Exception) request.getAttribute("error");
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      String refererURL = request.getHeader("Referer");
      // 오류를 보여준 후 돌아갈 위치의 정보를 가지고 있는 변수.
      System.out.println(refererURL);
      if(refererURL != null)
          out.printf("<meta http-equiv='Refresh' content='5;url=%s'>", refererURL);
      out.println("<title>예외 발생</title>");
      out.println("</head>");
      out.println("<body>");
      out.printf("<h1>%s<h1>", title);
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("</body>");
      out.println("</html>");
    }
}