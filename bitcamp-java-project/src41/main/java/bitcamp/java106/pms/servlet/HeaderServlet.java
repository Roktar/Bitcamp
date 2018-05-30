package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java106.pms.domain.Member;
// 공통 헤더 추가 서블릿
@SuppressWarnings("serial")
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    
    // LoginServlet에서 세션에 객체를 추가해두고 그 추가해둔 객체를 세션에 저장한다.
    // 세션은 클라이언트가 강제로 종료하거나 브라우저가 닫히거나 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        PrintWriter out = response.getWriter();
        
        out.println("<div id='header'> ");
            if(loginUser != null) {
                out.printf("%s\n", loginUser.getId());
                out.printf("<a href='%s/auth/logout'>로그아웃</a> ", request.getContextPath());
            } else
                out.printf("<a href='%s/auth/login'>로그인</a> ", request.getContextPath());
            out.println("</div> ");
    }
}