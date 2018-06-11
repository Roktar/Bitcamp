// 요청 핸들러의 파라미터 - 파라미터로 받을 수 있는 객체
package bitcamp.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_2") 
public class Exam05_2 {
   
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(@RequestParam("name") String name, @RequestParam("age") int age) {
        
        return String.format("name = %s, age = %d", name, age);
    }
    // 프론트 컨트롤러부터 클라이언트가 보낸 값을 파라미터로 바로 받을 수 있다.
    // => @RequestParam
    // 전에 RequestParam 만들었을 때를 생각해볼 것
    
    @GetMapping(value="m2")
    @ResponseBody
    public String m2(@RequestParam String name, @RequestParam int age) {
        
        return String.format("name = %s, age = %d", name, age);
    }
    
    @GetMapping(value="m3")
    @ResponseBody
    public String m3(String name, int age) {
        
        return String.format("name = %s, age = %d", name, age);
    } // 
    
    @GetMapping(value="m4")
    @ResponseBody
    public String m4(@RequestParam(required=false) String name, @RequestParam(required=false) int age) {
        
        return String.format("name = %s, age = %d", name, age);
    }
    
    @Autowired ServletContext ctx;
}







