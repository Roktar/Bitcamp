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
@RequestMapping("/exam06_3") 
public class Exam06_3 {

    @GetMapping(value="m1")
    public String m1() {
        return "/exam06_3.jsp";
    }
    
    // View 컴포넌트 URL을 View 구현체에 담아서 반환 가능
    // 잘 쓰는 방법은 아님.
    @GetMapping(value="m2")
    public View m2() {
        return new JstlView("/exam06_3.jsp");
    }
    
    // 보통 redirectView 대신 String 형식으로 앞에 redirect:를 붙여서 반환한다.
    @GetMapping(value="m3")
    public View m3() {
        return new RedirectView("../exam06_3.jsp");
    }
    
    @GetMapping(value="m4")
    public String m4() {
        return "redirect:../exam06_3.jsp";
    }
    
    // 데이터와 view URL을 동시에 반환할 때 사용하는 방법.
    @GetMapping(value="m5")
    public ModelAndView m5() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "홍길동");
        mv.addObject("age", 20);
        mv.setViewName("/exam06_3.jsp");
        return mv;
    }
}







