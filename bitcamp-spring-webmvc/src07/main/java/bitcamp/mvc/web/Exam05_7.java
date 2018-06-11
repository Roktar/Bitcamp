// 요청 핸들러의 파라미터 - HttpSession
package bitcamp.mvc.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/exam05_7") 
public class Exam05_7 {
   
    // 프론트 컨트롤러에게 Map이나 Model 객체 요구 시, 객체에 값을 담아놓으면 프론트컨트롤러가 객체에 담아놓은 값을 view 컴포넌트가 사용할 수 있도록 서블릿 리퀘스트 보관소에 복사.
    @GetMapping(value="m1")
    public String m1(Map<String, Object> map ) {
        map.put("name", "길동");
        map.put("age", 20);
        return "/exam05_7.jsp";
    }    
    
    @GetMapping(value="m2")
    public String m2(Model model ) {
        model.addAttribute("name", "길동");
        model.addAttribute("age", 20);
        return "/exam05_7.jsp";
    }    
    
    @GetMapping(value="m3")
    public ModelAndView m3() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "길동");
        mv.addObject("age", 20);
        mv.setViewName("/exam05_7.jsp");
        return mv;
    }   
}







