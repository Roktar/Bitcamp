// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/add")
public class TeamAddServlet extends HttpServlet {

    TeamDao teamDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getAppCtx().getBean(TeamDao.class);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 보낸 데이터가 어떤 문자표를 사용해서 작성한지 알아야만 
        // String 객체(UTF-16)로 값을 꺼낼 수 있다. 
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        Team team = new Team();
        team.setName(request.getParameter("name"));
        team.setDescription(request.getParameter("description"));
        team.setMaxQty(Integer.parseInt(request.getParameter("maxQty")));
        team.setStartDate(Date.valueOf(request.getParameter("startDate")));
        team.setEndDate(Date.valueOf(request.getParameter("endDate")));
        
        PrintWriter out = response.getWriter();
        
        try {
            teamDao.insert(team);
            response.sendRedirect("list");
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 추가 실패");
            request.getRequestDispatcher("../error").forward(request, response);
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.