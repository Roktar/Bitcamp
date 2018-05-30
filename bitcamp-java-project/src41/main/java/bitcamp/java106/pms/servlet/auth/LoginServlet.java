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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookies = request.getCookies();
        String id = "";
        
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("id")) {
                id = cookie.getValue();
                break;
            }
        } // 여러 쿠키들 중 id라는 키값으로 전송된 쿠키가 있는 지 찾는다.
        
        out.println("<!DOCTYPE html> ");
        out.println("<html> ");
        out.println("<head> ");
        out.println("<meta charset='UTF-8'> ");
        out.println("<title>LOGIN</title> ");
        out.println("</head> ");
        out.println("<body> ");

        out.println("<h1>로그인</h1> ");
        out.println("<form action='login' method='post'> ");
        out.printf("ID: <input type='text' name='id' value='%s'><br>\n ", id);
        out.println("PW: <input type='password' name='password'><br> ");
        out.println("<p><input type='checkbox' name='saveId' />아이디 저장</p>");
        out.println("<button>로그인</button> ");
        out.println("</form> ");

        out.println("</body> ");
        out.println("</html> ");
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
                response.sendRedirect(request.getContextPath()); // => "/bitcamp-java-project"
                session.setAttribute("loginUser", member);
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
