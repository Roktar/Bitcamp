package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        boardDao = WebApplicationContextUtils.getAppCtx(this.getServletContext()).getBean(BoardDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // include 사용 시, 컨텐츠타입은 여기서 지정해줘야한다.
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/header").include(request, response);
        
        try {
            List<Board> list = boardDao.selectList();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/board/list.jsp").include(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "게시물 조회 실패");
            request.getRequestDispatcher("../error").forward(request, response);
        }
    }
}

//ver 37 - BoardListController를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 list() 메서드를 추출하여 클래스로 정의. 