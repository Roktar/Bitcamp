package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        // 스프링 IoC 컨테이너에서 서블릿 객체를 관리하는 것이 아니기 때문에
        // 스프링 IoC 컨테이너에 들어 있는 DAO 객체를 자동으로 주입 받을 수 없다.
        // 서블릿을 생성할 때 스프링 IoC 컨테이너에서 직접 DAO를 꺼내와야 한다.
        boardDao = InitServlet.getAppCtx().getBean(BoardDao.class);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        try {
            Board board = new Board();
            String title = request.getParameter("title");
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));
            
            if(title.length() < 1)
                throw new Exception("등록에서 문제 발생!");
            
            boardDao.insert(board);
            response.sendRedirect("list");
            
        } catch (Exception e) {
            // 문제발생 시 문제에 대한 정보를 전달한다.
            request.setAttribute("error", e);
            request.setAttribute("title", "게시물 등록 실패");
            request.getRequestDispatcher("../error").forward(request, response);
        }
    }
}

//ver 39 - forword 적용
//ver 38 - redirect 적용
//ver 37 - BoardAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
