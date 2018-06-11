// 요청 핸들러의 반환값 - HTTPEntity에 담아서 반환
package bitcamp.mvc.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam06_2") 
public class Exam06_2 {
   
    @GetMapping(value="m1")
    @ResponseBody
    public HttpEntity<String> m1() {
        HttpEntity<String> entity = new HttpEntity<>("06_1.m1 -> 012ABCabc#!@가각간\"");
        return entity;
    }
    
    // 사용 문자표 변경
    @GetMapping(value="m2")
    @ResponseBody
    public HttpEntity<String> m2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<>("06_1.m2 -> 012ABCabc#!@가각간", headers);
        return entity;
    }
    
    // ResponseEntity는 HttpEntity의 자식 클래스. 
//    응답 시 상태코드 설정 가능
    @GetMapping(value="m3")
    @ResponseBody
    public ResponseEntity<String> m3() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        ResponseEntity<String> entity = new ResponseEntity<>("06_1.m3 -> 012ABCabc#!@가각간", headers, HttpStatus.OK);
        return entity;
    }
}







