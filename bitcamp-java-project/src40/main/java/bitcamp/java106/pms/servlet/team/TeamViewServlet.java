// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/view")
public class TeamViewServlet extends HttpServlet {

    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TeamDao.class);
        teamMemberDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            Team team = teamDao.selectOne(name);
    
            if (team == null) 
                throw new Exception("유효하지 않은 팀입니다.");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>팀 보기</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>팀 보기</h1>");
            
            out.println("<form action='update' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.printf("    <th>팀명</th><td><input type=\"text\" name=\"name\" value='%s' readonly></td>\n",
                    team.getName());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>설명</th><td><textarea name=\"description\" ");
            out.printf("        rows=\"6\" cols=\"60\">%s</textarea></td>\n",
                    team.getDescription());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>최대인원</th><td><input type=\"number\" name=\"maxQty\" value='%d'></td>\n",
                    team.getMaxQty());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>시작일</th><td><input type=\"date\" name=\"startDate\" value='%s'></td>\n", 
                    team.getStartDate());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>종료일</th><td><input type=\"date\" name=\"endDate\" value='%s'></td>\n", 
                    team.getEndDate());
            out.println("</tr>");
            out.println("</table>");
            out.println("<button>변경</button>");
            out.printf("<a href='delete?name=%s'>삭제</a>\n", name);
            out.printf("<a href='../task/list?teamName=%s'>작업목록</a>", name);
            out.println("</form>");
                        
            out.println("</table>");
            out.println("</form>");
            
            // 팀 회원 출력은 TeamMemberListServlet에게 위임한다. 
            request.getRequestDispatcher("/team/member/list").include(request, response);
            // forward였으면 teamView 서블릿은 무시되었을 것이지만 include는 이전 서블릿 포함이기때문에 
            // 두 개의 서블릿의 결과가 출력된다.
            // name이란 인자가 필요한데, 이미 name이라는 인자가 들어있는 reqeust를 다시 넘겨줬기때문에 파라미터를 추가하지않아도된다.
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 상세조회 실패");
            request.getRequestDispatcher("/error").forward(request, response);
        }
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