package bitcamp.java106.pms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Component
@RequestMapping("/board")
public class BoardController {
    
    BoardDao boardDao;
    
    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping("form")
    public void form(/*Model model*/) {
        // 입력폼에서 사용할 ㄷ데이터가 있다면, 이 핸들러에서 준비하면된다.
       // model.addAttribute("PropertyName", VALUE);
    }
    
    @RequestMapping("add")
    public String add(Board board) throws Exception {
        boardDao.insert(board);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        
        int count = boardDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 게시물이 없습니다.");
        }
        return "redirect:list";
    }
    
    @RequestMapping("list{page}")
    public void list(@PathVariable String page, @MatrixVariable(defaultValue="1") int pageNo, @MatrixVariable(defaultValue="3") int pageSize, Map<String,Object> map) throws Exception {        
        Map<String, Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo -1) * pageSize);
        params.put("pageSize", pageSize);
                
        List<Board> list = boardDao.selectList(params);
        map.put("list", list);
        // list.jsp를 찾을 것이다.
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception {
        
        int count = boardDao.update(board);
        if (count == 0) {
            throw new Exception("해당 게시물이 존재하지 않습니다.");
        } 
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Map<String,Object> map) throws Exception {
        
        Board board = boardDao.selectOne(no);
        if (board == null)
            throw new Exception("유효하지 않은 게시물 번호입니다.");
        map.put("board", board);
        return "/board/view";
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






