// 세션 사용 - 데이터 꺼내기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller 
@RequestMapping("/exam08_4") 
@SessionAttributes({"name", "age", "working"})
public class Exam08_4 {
    
  @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String m1(@ModelAttribute("name") String name, @ModelAttribute("age") int age, @ModelAttribute("working") boolean working) {
      // 세션에 데이터 보관
      // 테스트방법
      // ~/mvc/exam08_1/m1?name=hong
      
      return String.format("m1: ModelAttribute 어노테이션으로 값 꺼내기 - name=%s, age=%d, working=%b", name, age, working);                          
  }
    

    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(SessionStatus status) {
        status.setComplete();
        
        return "m2 - status로 세션 무효화";
    }
    
    @GetMapping(value="m4", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m4(
            @ModelAttribute("name") String name, 
            @ModelAttribute("age") int age) {
        // 세션에 보관된 값을 꺼내 출력하기
        return String.format("m4(): name=%s, age=%d", 
                name, age);
    }
}

//    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
//    @ResponseBody
//    public String m1(HttpSession session) {
//        // 세션에 데이터 보관
//        // 테스트방법
//        // ~/mvc/exam08_1/m1?name=hong
//        
//        return String.format("m1: name=%s, age=%d, working=%b", 
//                                  session.getAttribute("name"),
//                                  session.getAttribute("age"),
//                                  session.getAttribute("working")
//                                  );                          
//    }

/*    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) {
        // 세션에 데이터 보관
        // 테스트방법
        // ~/mvc/exam08_1/m1?name=hong
        session.invalidate();
        return String.format("세션 초기화");
    }*/

//    
//    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
//    @ResponseBody
//    public String m3(@ModelAttribute("name") String name, @ModelAttribute("age") int age, @ModelAttribute("working") boolean working) {
//        // 세션에 데이터 보관
//        // 테스트방법
//        // ~/mvc/exam08_1/m1?name=hong
//        
//        return String.format("m3: name=%s, age=%d, working=%b", 
//                name, age, working);                          
//    }
