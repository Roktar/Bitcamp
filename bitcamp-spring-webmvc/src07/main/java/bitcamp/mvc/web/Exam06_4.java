// 요청 핸들러의 반환값 - View 컴포넌트 URL 또는 이름 반환
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.RedirectView;

@Controller 
@RequestMapping("/exam06_4") 
public class Exam06_4 {

    @GetMapping(value="m1")
    public String m1() {
        return "/exam06_3.jsp";
    }
    
}







