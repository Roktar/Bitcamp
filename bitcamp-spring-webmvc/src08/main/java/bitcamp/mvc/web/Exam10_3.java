// 스프링 설정 + 잭슨 라이브러리로 JSON 출력
package bitcamp.mvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.mvc.dao.BoardDao;

// JSON 데이터를 출력하는 페이지 컨트롤러일 경우, 다음 어노테이션을 사용하여 표시하라

@RestController 
@RequestMapping("/exam10_3") 
public class Exam10_3 {
    BoardDao boardDao;
    // or @Autowired, 이미 생성된 객체를 꽂아줌.
    
    public Exam10_3(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping(value="list")
    public Object list() {
        
        return boardDao.selectList();
        // viewResolver는 등록되어있기때문에 prefix, suffix는 자동으로 붙는다.
    }
}

