// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/member/list")
public class TeamMemberListServlet extends HttpServlet {
    // 팀 멤버 리스트만 가져올 것이기에 팀멤버 다오만 있으면 된다.
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamMemberDao =  WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // 즉, 이 전의 서블릿에서 문자셋을 지정할 것이기때문.
        //request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        
        // include하기 전의 서블릿에서 컨텐츠 타입을 설정했을 것이기때문에 의미가 없다.
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            List<Member> members = teamMemberDao.selectListWithEmail(name);
            
            out.println("<h2>회원 목록</h2>");
            out.println("<form action='http://localhost:8888/bitcamp-java-project/team/member/add' method='post'>");
            // or action='member/add'
            out.printf("<input type='hidden' name='teamName' value='%s'/><br>", name);
            out.println("<input type='text' name='memberId' placeholder='회원 ID를 입력하십시오.' /><br>");
            out.println("<button>추가</button>");
            out.println("<table border=1>");
            out.println("<tr>");
            out.println("<th>계정</th><th>이메일</th><th> </th>");
            out.println("</tr>");
            
            for(Member member : members) {
                out.println("<tr>");
                out.printf("<td> %s </td><td> %s </td><td> <a href='member/delete?teamName=%s&memberId=%s'>삭제</a> </td>", member.getId(), member.getEmail(), name, member.getId());
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</form>");
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 회원조회 실패");
            request.getRequestDispatcher("/error").forward(request, response);
        }
        out.println("<p>");
        out.println("<a href='list'>목록</a>");
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.