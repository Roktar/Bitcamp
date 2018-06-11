// 요청 핸들러의 파라미터 - 파라미터로 받을 수 있는 객체
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.vo.Board;

@Controller 
@RequestMapping("/exam05_3") 
public class Exam05_3 {
   
    // 프론트 컨트롤러부터 클라이언트가 보낸 값을 파라미터로 바로 받을 수 있다.
    // => @RequestParam, 받는 타입이 객체인 경우 객체를 자동으로 생성해서 반환한다.
    // 전에 RequestParam 만들었을 때를 생각해볼 것
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(Board board) {
        return String.format("m1 : no=%d, title=%s, content=%s", board.getNo(), board.getTitle(), board.getContent());
    }
    
    // 객체요소는 객체에 넣고 아닌 것은 별도로 분리하여 받을 수 있다.
    @GetMapping(value="m2")
    @ResponseBody
    public String m2(Board board, String writer) {
        return String.format("m2 : no=%d, title=%s, content=%s, writer=%s", board.getNo(), board.getTitle(), board.getContent(), writer);
    }
    
    // 특정 객체 안에 다른 객체를 넣을 때.
    @GetMapping(value="m3")
    @ResponseBody
    public String m3(Board board) {
        return String.format("m3 : %s", board);
    }
}







