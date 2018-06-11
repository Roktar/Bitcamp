// @RequestMapping - HTTP 헤더로 메서드 구분하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam04_4") 
public class Exam04_4 {
    
    // 클라이언트가 서버로 데이터를 보낼 때 사용됨.
    
    // 다음 메소드는 get처럼 파라미터=값&파라미터=값.. 으로 구성된 경우에 사용된다.
    @PostMapping(value="post", consumes = "application/x-www-form-urlencoded" )  
    @ResponseBody  
    public String m1() {
        // plain text로 만들어서 전송
        return "Exam04_3.m1()";
    }
    
    // 다음 메소드는 값, 값, 값, 값.. 으로 구성된 경우에 사용된다.
    @PostMapping(value="post", consumes = "text/csv")  
    @ResponseBody  
    public String m2() {
        // html text로 만들어서 전송
        return "Exam04_3.m2()";
    }
    
    // 다음 메소드는 {파라미터명:값, 파라미터명:값 .. } 으로 구성된 경우에 사용된다.
    @PostMapping(value="post", consumes = "application/json")  
    @ResponseBody  
    public String m3() {
        // pdf 형식으로 만들어서 전송
        return "Exam04_3.m3()";
    }
}







