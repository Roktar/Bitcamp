package bitcamp.java106.pms.servlet.classroom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/classroom/delete")
public class ClassroomDeleteServlet extends HttpServlet {
    
    ClassroomDao classroomDao;
    
    @Override
    public void init() throws ServletException {
        classroomDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(ClassroomDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        int no = Integer.parseInt(request.getParameter("no"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            int count = classroomDao.delete(no);
            
            if (count == 0) 
              throw new Exception("<p>해당 강의가 없습니다.</p>");
            response.sendRedirect("list");
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "강의 삭제 실패");
            request.getRequestDispatcher("../error").forward(request, response);
        }
    }
}

//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 delete() 메서드를 추출하여 클래스로 정의.
