// 세션 사용 - 데이터 꺼내기
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam08_2") 
public class Exam08_2 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpSession session) {
        // 세션에 데이터 보관
        // 테스트방법
        // ~/mvc/exam08_1/m1?name=hong
        
        return String.format("m1: 세션에서 직접 값 꺼내기 - name=%s, age=%d, working=%b", 
                                  session.getAttribute("name"),
                                  session.getAttribute("age"),
                                  session.getAttribute("working")
                                  );                          
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) {
        // 세션에 데이터 보관
        // 테스트방법
        // ~/mvc/exam08_1/m1?name=hong
        session.invalidate();
        return String.format("세션 초기화 - Direct");
    }
}

