package bitcamp.java106.pms.web.json;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.TestBoard;
import bitcamp.java106.pms.service.BoardService;

// 일반 Controller를 사용한다면 
// 메소드에 @ResponseBody 메소드를 붙여야한다.
@RestController
@RequestMapping("/board")
public class BoardController {
    
    BoardService boardService;
    
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    
    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(Board board) throws Exception {
        boardService.add(board);
    }
    
    @RequestMapping("delete")
    public void delete(int no) throws Exception {
        boardService.delete(no);
    }
    
    @RequestMapping(value="list{page}", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Board> list(@PathVariable String page, @MatrixVariable(defaultValue="1") int pageNo, @MatrixVariable(defaultValue="3") int pageSize) {        
        return boardService.list(pageNo, pageSize);
    }
    
    @RequestMapping(value="testlist{page}", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<TestBoard> test_list(@PathVariable String page, HttpServletRequest request, @MatrixVariable(defaultValue="1") int pageNo, @MatrixVariable(defaultValue="3") int pageSize) {        
        int pageNo1 = Integer.parseInt(request.getParameter("pageNo"));
        return boardService.test_list(pageNo1, pageSize);
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK) // 기본값은 OK(200)이다.
    public void update(Board board) throws Exception {
        boardService.update(board);
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        Board board = boardService.get(no);
        if (board == null)
            throw new Exception("유효하지 않은 게시물 번호입니다.");
        return board;
    }
}

//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - 필터 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - BoardAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 






