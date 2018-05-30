package bitcamp.java106.pms.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    MemberDao memberDao;
    
    @Override
    public void init() throws ServletException {
        memberDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(MemberDao.class);
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String pw = request.getParameter("password");
        Cookie cookie = null;
        
        if(request.getParameter("saveId") != null) { // 아이디 저장 기능이 on일 때
            cookie = new Cookie("id", id); // 현재 id 정보를 쿠키에 세팅한다
            cookie.setMaxAge(60*60*24*7); // 쿠키의 유효기간을 지정한다.
        } else { // 저장이 off일 때 (off면 애초에 해당 쿠키에 값이 지정되지 않음)
            cookie = new Cookie("id", ""); // 쿠키의 값을 제거하고
            cookie.setMaxAge(0); // 유효시간을 0으로 만든다.
        }
        
        response.addCookie(cookie);
        HttpSession session = request.getSession();
                
        try {
            Member member = memberDao.selectOneWithPassword(id, pw);
            
            if (member != null) { // 로그인 성공!
                String refererURL = (String) session.getAttribute("Referer");
                session.setAttribute("Referer", null);
                System.out.println(refererURL);
                if(refererURL == null) // 로그인 실패했을 때 : 메인 화면으로 이동
                    response.sendRedirect(request.getContextPath());
                else {
                    session.setAttribute("loginUser", member);
                    response.sendRedirect(refererURL); // => "/bitcamp-java-project"
                }
                return;
            } else { // 로그인 실패!
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                String refererUrl = request.getHeader("Referer");
                if (refererUrl != null) {
                    out.printf("<meta http-equiv='Refresh' content='1;url=%s'>", 
                            request.getContextPath() + "/auth/login"); 
                }
                out.println("<title>로그인</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>로그인 실패!</h1>");
                out.println("<p>아이디 또는 암호가 맞지 않습니다.</p>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "로그인 실패!");
            요청배달자.forward(request, response);
        }
    }
}
