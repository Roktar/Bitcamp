// 요청 핸들러의 반환값 - 컨텐트를 직접 반환
package bitcamp.mvc.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam06_1") 
public class Exam06_1 {
   
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(ServletRequest request, ServletResponse response) {
        
        return "06_1.m1";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(ServletRequest request, ServletResponse response) {
        
        return "06_1.m2 - 012ABCabc#!@가각간";
    }
}







