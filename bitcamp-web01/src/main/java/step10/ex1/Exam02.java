package step10.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex1/exam02")
public class Exam02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1
        Cookie[] cks = request.getCookies(); // 쿠키는 특정 쿠키를 가져오는 메소드가 없다.
        
        response.setContentType("text/plain;charset=UTF-8 ");
        PrintWriter out = response.getWriter();
        out.println("[클라이언트가 보낸 쿠키]");
        
        for(Cookie ck : cks) {
            out.printf("%s=%s\n", ck.getName(), ck.getValue());
        }
    }
}
