// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {

    MemberDao memberDao;
    
    @Override
    public void init() throws ServletException {
        memberDao = InitServlet.getAppCtx().getBean(MemberDao.class);
    }

    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            Member member = memberDao.selectOne(id);
            if (member == null) {
                throw new Exception("유효하지 않은 회원 아이디입니다.");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>회원 보기</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>회원 보기</h1>");
            out.println("<form action='update' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr><th>아이디</th><td>");
            out.printf("    <input type='text' name='id' value='%s' readonly></td></tr>\n", 
                    member.getId());
            out.println("<tr><th>이메일</th>");
            out.printf("    <td><input type='text' name='email' value='%s'></td></tr>\n",
                    member.getEmail());
            out.println("<tr><th>암호</th>");
            out.printf("    <td><input type='text' name='password' value='-'></td></tr>\n");
            out.println("</table>");
            
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta http-equiv='Refresh' content='list'");
            out.println("<title>회원 보기</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>회원 보기</h1>");
            out.println("<form action='update' method='post'>");

            out.printf("<p>%s</p>\n", e.getMessage());
            e.printStackTrace(out);
            
            out.println("</body>");
            out.println("</html>");
        }
        out.println("<p>");
        out.println("<a href='list'>목록</a>");
        out.println("<button>변경</button>");
        out.printf("<a href='delete?id=%s'>삭제</a>\n", id);
        out.println("</p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - MemberController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - MemberDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 MemberDao를 사용한다.
//         onMemberList()에서 배열의 각 항목에 대해 null 값을 검사하는 부분을 제거한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - MemberDao를 생성자에서 주입 받도록 변경.
// ver 14 - MemberDao를 사용하여 회원 데이터를 관리한다.
