package step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet 생성
// - httpServlet의 메소드 재정의
@WebServlet("/step01/exam05")
public class Exam05 extends HttpServlet {
    // 클라이언트로부터 요청이 들어오면
    // HTTP 명령에 따라 do 메소드 중 하나가 호출될 것이다.
    // 재정의하지않았기때문에 원래 썼던대로 실행될 것이다.
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain;charset=UTF-8");
        res.getWriter().println("Exam05의 get");
    }
}
