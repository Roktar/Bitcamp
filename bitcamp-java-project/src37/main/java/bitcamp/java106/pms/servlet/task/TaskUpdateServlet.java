// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/update")
public class TaskUpdateServlet extends HttpServlet {
    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String teamName = request.getParameter("teamName");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.printf("<meta http-equiv='Refresh' content='1;url=list?teamName=%s'>\n", teamName);
        out.println("<title>작업 등록</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>'%s' 팀의 작업 변경</h1>\n", teamName);
        
        try {
            Task task = new Task()
                .setNo(Integer.parseInt(request.getParameter("no")))
                .setTitle(request.getParameter("title"))
                .setStartDate(Date.valueOf(request.getParameter("startDate")))
                .setEndDate(Date.valueOf(request.getParameter("endDate")))
                .setState(Integer.parseInt(request.getParameter("state")))
                .setTeam(new Team().setName(request.getParameter("teamName")))
                .setWorker(new Member().setId(request.getParameter("memberId")));
            
            Team team = teamDao.selectOne(task.getTeam().getName());
            if (team == null) {
                throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
            }
            
            if (task.getWorker().getId().length() > 0 && !teamMemberDao.isExist(
                    task.getTeam().getName(), task.getWorker().getId())) {
                throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
            }
            
            int count = taskDao.update(task);
            if (count == 0) {
                out.println("해당 작업이 없습니다.");
            } else {
                out.println("변경하였습니다.");
            }
        } catch (Exception e) {
            out.println("변경 실패!");
            e.printStackTrace(out);
        }
    }

}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 update() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성