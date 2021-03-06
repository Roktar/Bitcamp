package bitcamp.java106.pms.controller.teammember;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@Component("/team/member/list")
public class TeamMemberListController implements PageController {

    TeamMemberDao teamMemberDao;
    
    public TeamMemberListController(TeamMemberDao teamMemberDao) {
        this.teamMemberDao = teamMemberDao;
    }
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String name = request.getParameter("name");
        List<Member> members = teamMemberDao.selectListWithEmail(name);
        request.setAttribute("members", members);
        return "/team/member/list.jsp";
    }
}

//ver 42 - JSP 적용
//ver 39 - forward 적용
