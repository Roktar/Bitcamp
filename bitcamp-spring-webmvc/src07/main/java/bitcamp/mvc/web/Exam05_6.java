// 요청 핸들러의 파라미터 - 파라미터로 받을 수 있는 객체
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_6") 
public class Exam05_6 {
   
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(@RequestHeader("User-Agent") String userAgent, @RequestHeader(value="Content-Type", required=false) String contentType, @RequestHeader("Accept") String accept ) {
        return String.format("m1 : \n%s\n%s\n%s\n", userAgent, contentType, accept);
    }    
}







