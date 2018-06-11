// 요청 핸들러의 파라미터 - 쿠키 받기
package bitcamp.mvc.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_8") 
public class Exam05_8 {
   
    // 프론트 컨트롤러에게 Map이나 Model 객체 요구 시, 객체에 값을 담아놓으면 프론트컨트롤러가 객체에 담아놓은 값을 view 컴포넌트가 사용할 수 있도록 서블릿 리퀘스트 보관소에 복사.
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpServletResponse response) {
        try {
            Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
            response.addCookie(c1);
            Cookie c2 = new Cookie("age", "20");
            response.addCookie(c2);
            
            return "쿠키값 전송";
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }  
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(@CookieValue(value="name") Cookie name, @CookieValue(value="age", defaultValue="0") int age ) {
        try {
            return String.format("m2:name=%s, age=%d\n", URLDecoder.decode(name.getValue(), "UTF-8"), age);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }   
}







