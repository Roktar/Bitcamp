package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/classroom/update")
public class ClassroomUpdateServlet extends HttpServlet {
    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        classroomDao = InitServlet.getAppCtx().getBean(ClassroomDao.class);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        Classroom classroom = new Classroom();
        classroom.setNo(Integer.parseInt(request.getParameter("no")));
        classroom.setTitle(request.getParameter("title"));
        classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
        classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
        classroom.setRoom(request.getParameter("room"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        try {
            int count = classroomDao.update(classroom);
            if (count == 0) {
                throw new Exception("<p>해당 강의가 존재하지 않습니다.</p>");
            }
            out.println("<script> alert('변경하였습니다.'); </script>");
            response.sendRedirect("list");
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "강의 변경 실패");
            request.getRequestDispatcher("../error").forward(request, response);
        }
    }
}

//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 update() 메서드를 추출하여 클래스로 정의.