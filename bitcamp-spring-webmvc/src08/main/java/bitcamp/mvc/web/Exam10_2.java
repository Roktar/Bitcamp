// JSON Data
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.mvc.dao.BoardDao;

@Controller 
@RequestMapping("/exam10_2") 
public class Exam10_2 {
    BoardDao boardDao;
    // or @Autowired, 이미 생성된 객체를 꽂아줌.
    
    public Exam10_2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping(value="list", produces="text/plain;charset=UTF-8")
    @ResponseBody() // JSP 파일 주소가 아님을 명시한다.(단순 데이타), 일반 객체를 반환할 때 스프링에서 자동으로 JSON으로 바꿔서 응답한다.
    public String list() {
        // GSON 라이브러리를 이용하여 객체를 JSON 문자열로 변환한다.
        String json = new Gson().toJson(boardDao.selectList());
        
        return json;
        // viewResolver는 등록되어있기때문에 prefix, suffix는 자동으로 붙는다.
    }
}

