// 인터셉터
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.mvc.dao.BoardDao;

@Controller 
@RequestMapping("/exam10_1") 
public class Exam10_1 {
    BoardDao boardDao;
    // or @Autowired, 이미 생성된 객체를 꽂아줌.
    
    public Exam10_1(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping(value="list")
    public String list(Model model) {
        model.addAttribute("boards", boardDao.selectList());
        
        return "exam10_1";
        // viewResolver는 등록되어있기때문에 prefix, suffix는 자동으로 붙는다.
    }
}

