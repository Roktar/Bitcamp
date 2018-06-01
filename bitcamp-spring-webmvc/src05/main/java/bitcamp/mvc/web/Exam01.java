package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("web.HelloController")
public class Exam01 {
    
    public Exam01() {
        System.out.println("exam01 생성");
    }
    
    @RequestMapping("/exam01/m1")
    @ResponseBody
    public String m1() {
        return "Hello";
    }
}
