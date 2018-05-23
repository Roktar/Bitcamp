// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/task/delete")
public class TaskDeleteServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    @Override
    public void init() throws ServletException {
    	this.teamDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TeamDao.class);
    	this.taskDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(TaskDao.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	String teamName = request.getParameter("teamName");
    	    	
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            int count = taskDao.delete(no);
            if (count == 0)
                throw new Exception("<p>해당 작업이 존재하지 않습니다.</p>");
            response.sendRedirect("list?teamName=" + teamName);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 삭제 실패");
            request.getRequestDispatcher("../error").forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 delete() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
