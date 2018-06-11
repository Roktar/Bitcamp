// 요청 핸들러의 파라미터 - 쿠키 받기
package bitcamp.mvc.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bitcamp.mvc.vo.Board;

@Controller 
@RequestMapping("/exam05_9") 
public class Exam05_9 {
   
    @PostMapping(value="post")
    @ResponseBody
    public String m1(String name, int age, String tel) {
        return String.format("m1 : name=%s, age=%d, tel=%s", name, age, tel);
    }  
    
    // 한 줄로 다 담겨서 오는 경우, 나눠서 받을 수 없기때문에 한 번에 받아야한다.
    @PostMapping(value="post", consumes="text/plain")
    @ResponseBody
    public String m2(@RequestBody String content) {
        return String.format("m2 : %s", content);
    }  
    
    @PostMapping(value="post", consumes="text/csv")
    @ResponseBody
    public String m3(@RequestBody String content) {
        String[] values = content.split(", ");
        
        return String.format("m3 : name=%s, age=%d, tel=%s", values[0], values[1], values[2]);
    }  
    
    @PostMapping(value="post", consumes="application/json")
    @ResponseBody
    public String m4(@RequestBody String content) {
        
        //google-gson 라이브러리 사용
        @SuppressWarnings("unchecked")
        Map<String, Object> map = new Gson().fromJson(content, Map.class);
        
        return String.format("m4 : name=%s, age=%f, tel=%s", map.get("name"), map.get("age"), map.get("tel"));
    }  
    
    @PostMapping(value="post2", consumes="application/json")
    @ResponseBody
    public String m5(@RequestBody String content) {
        
        //google-gson 라이브러리 사용
        //단, 날짜는 자동으로 파싱이 안되므로 미리 빌더 객체를 통해 날짜를 객체로 만든다.
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Board board = gson.fromJson(content, Board.class);
        
        return String.format("m4 : no=%s, title=%s, content=%s, createdDate=%s", board.getNo(), board.getTitle(), board.getContent(), board.getCreatedDate() );
    }  
}







