// 인터셉터
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

@Controller 
@RequestMapping("/exam09_1") 
public class Exam09_1 {
    
    @GetMapping(value="aaa/m1", produces="text/plain;charset=UTF-8")
    public String m1(String name, HttpSession session) {
        System.out.println("m1");
        return "exam09_1";
    }
    
    @GetMapping(value="aaa/m2", produces="text/plain;charset=UTF-8")
    public String m2(String name, HttpSession session) {
        System.out.println("m2");
        return "exam09_1";
    }
    
    @GetMapping(value="bbb/m3", produces="text/plain;charset=UTF-8")
    public String m3(String name, HttpSession session) {
        System.out.println("m3");

        return "exam09_1";
    }
}

