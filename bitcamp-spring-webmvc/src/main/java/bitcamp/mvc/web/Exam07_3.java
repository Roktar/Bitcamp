// 경로 변수
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam07_3") 
public class Exam07_3 {
    
    @GetMapping(value="m1/{value}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(@PathVariable String value) {
        // 클라이언트에서 다음과 같은 형식으로 데이터를 보낼 때 :
        // - .../exam07_3/m1/teamA-hong-100
        return String.format("m1: value=%s", value);
    }
    
    // 정규표현식을 사용하여 추출
    // - URI가 특정 규칙과 일치할 때에 메소드를 호출하게 할 수 있다.
    @GetMapping(value="m2/{team:t[a-zA-Z]+}-{member:m[a-z0-9]+}-{doc:[0-9]+}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(@PathVariable String team, @PathVariable String member, @PathVariable int doc) {
        return String.format("m2: team=%s, member=%s, doc=%d", team, member, doc);
    }
}

