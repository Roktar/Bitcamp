// 세션 사용 - @SessionAttribute
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

// 세션 보관소가 아닌 서블릿리퀘스트 저장소에 저장하는 것이기때문에 세션객체에선 꺼낼 수 없다.

@Controller 
@RequestMapping("/exam08_3") 
@SessionAttributes( {"name", "age", "working" } )
public class Exam08_3 {
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, Model model) {
        
        // 세션 보관소에 데이터를 직접 저장하는 대신 Model(or Map) 객체에 저장
        model.addAttribute("name", name);
        return String.format("m1 = 모델 객체를 통해 세션에 값 넣기 -  name:%s", name);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(int age, Model model) {
        
        // 세션 보관소에 데이터를 직접 저장하는 대신 Model(or Map) 객체에 저장
        model.addAttribute("age", age);
        return String.format("m2 = age:%d", age);
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(boolean working, Model model) {
        
        // 세션 보관소에 데이터를 직접 저장하는 대신 Model(or Map) 객체에 저장
        model.addAttribute("working", working);
        return String.format("m3 = working:%b", working);
    }

}

