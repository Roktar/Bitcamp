// 요청 핸들러의 파라미터 - 파라미터로 받을 수 있는 객체
package bitcamp.mvc.web;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_5") 
public class Exam05_5 {
   
    // 커스텀 프로퍼티 에디터 등록
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1 : %s, %s, %s", title, content, createdDate);
    }    
}







