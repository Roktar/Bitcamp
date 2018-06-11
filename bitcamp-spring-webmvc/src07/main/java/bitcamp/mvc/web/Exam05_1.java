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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_1") 
public class Exam05_1 {
   
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(ServletRequest request, ServletResponse response) {
        
        return "05-01";
    }
    // 리퀘스트, 리스폰스 객체를 받아올 수 있다. => 단순 선언만 해두면 자동으로 값이 들어와진다.
    // 전에 RequestParam 만들었을 때를 생각해볼 것
    
    @GetMapping(value="m2")
    @ResponseBody
    public String m2(ServletRequest request, ServletResponse response) {
        
        return "05-02";
    }
    
    @GetMapping(value="m3")
    @ResponseBody
    public String m3(HttpSession session) {
        
        return "05-03";
    }
    
/*    @GetMapping(value="m4")
    @ResponseBody
    public String m4(ServletContext servletContext) {
        
        return "05-04";
    }*/
    
    @Autowired ServletContext ctx;
}







