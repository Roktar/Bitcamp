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

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/task/update")
public class TaskUpdateServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    
    @Override
    public void init() throws ServletException {
        this.teamDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TeamDao.class);
        this.taskDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TaskDao.class);
        this.teamMemberDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String teamName = request.getParameter("teamName");
        
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
            if (count == 0)
                throw new Exception("해당 작업이 없습니다.");
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 변경 실패");
            request.getRequestDispatcher("../error").forward(request, response);
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