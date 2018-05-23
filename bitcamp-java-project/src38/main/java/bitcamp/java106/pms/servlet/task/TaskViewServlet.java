// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/view")
public class TaskViewServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        this.teamDao = InitServlet.getAppCtx().getBean(TeamDao.class);
        this.taskDao = InitServlet.getAppCtx().getBean(TaskDao.class);
        this.teamMemberDao = InitServlet.getAppCtx().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>작업 상세정보 페이지</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>작업 상세보기</h1>");
        
        int no = Integer.parseInt(request.getParameter("no"));
        String teamName = request.getParameter("teamName");
        
        try {
            Task task = taskDao.selectOne(no);
            if (task == null)
                throw new Exception("<p>해당 작업을 찾을 수 없습니다.</p>");
                
            List<Member> members = teamMemberDao.selectListWithEmail(task.getTeam().getName());
            
            out.println("<form action='update' method='post'>");
            out.printf("<input type='hidden' name='no' value='%d'>\n", no);
            
            out.println("<table border='1'>");
            out.println("<tr>");
            out.printf("    <th>팀명</th>"
                    + "      <td><input type='text' name='teamName' value='%s' readonly></td>", task.getTeam().getName());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>작업명</th>"
                    + "      <td><input type='text' name='title' value='%s'></td>", task.getTitle());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>시작일</th>"
                    + "      <td><input type='date' name='startDate' value='%s'></td>", task.getStartDate());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>종료일</th>"
                    + "      <td><input type='date' name='endDate' value='%s'></td>", task.getEndDate());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>작업자</th>");
            out.println("    <td>");
            out.println("        <select name='memberId'>");
            out.println("            <option></option>");
            
            String worker = null;
            if(task.getWorker() != null)
                worker = task.getWorker().getId();
            
            for (Member member : members) {
                out.printf("            <option %s>%s</option>\n", 
                        (member.getId().equalsIgnoreCase(worker)) ? "selected" : "", 
                        member.getId());
            }
            
            out.println("        </select>");
            out.println("    </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>작업 상태</th> <td><select name='state'>");
            out.printf("       <option %s value='0'>작업 대기</option>\n", (task.getState() == 0 ? "selected" : ""));
            out.printf("       <option %s value='1'>작업중</option>\n", (task.getState() == 1 ? "selected" : ""));
            out.printf("       <option %s value='9'>작업 완료</option>\n", (task.getState() == 9 ? "selected" : ""));
            out.println("   </select> </td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<button>변경</button>");
            out.printf("<a href='delete?no=%d&teamName=%s'>삭제</a>", no, task.getTeam().getName());
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.printf("<meta http-equiv='Refresh' content='list?teamName=%s'", teamName);
            out.println("<title>작업 상세정보 페이지</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>작업 상세보기</h1>");
            out.printf("<p>%s</p>", e.getMessage());
            e.printStackTrace(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static String getStateLabel(int state) {
        switch (state) {
        case Task.READY: return "작업대기";
        case Task.WORKING: return "작업중";
        case Task.COMPLETE: return "작업완료";
        default:
            return null;
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성