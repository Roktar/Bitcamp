// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/task/list")
public class TaskListServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.teamDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TeamDao.class);        
        this.taskDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TaskDao.class);   
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String teamName = request.getParameter("teamName");
        
        request.getRequestDispatcher("/header").include(request, response);

        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null)
                throw new Exception("<p>" + teamName +" 팀은 존재하지 않습니다.</p>");
            
            List<Task> list = taskDao.selectList(team.getName());
            request.setAttribute("teamName", teamName);
            request.setAttribute("list", list);
            request.getRequestDispatcher("list.jsp").include(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 조회 실패");
            request.getRequestDispatcher("../error").forward(request, response);
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 list() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성