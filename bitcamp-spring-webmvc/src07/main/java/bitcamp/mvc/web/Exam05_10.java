// 요청 핸들러의 파라미터 - @RequestPart 사용
package bitcamp.mvc.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/exam05_10") 
public class Exam05_10 {
   
    
    @Autowired ServletContext sc;
    // 멀티파트 형식 데이터를 꺼낼 때는 스프링 웹MVC에 멀티파트 데이터ㅏ를 처리하는 객체를 등록해야한다.
    // ==> 그 객체가 의존하는 아파치 파일업로드 라이브러리도 추가해야한다.
    @PostMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, int age, MultipartFile photo) throws Exception {
        
        String filePath = sc.getRealPath("/" + photo.getOriginalFilename());
        photo.transferTo(new File(filePath));
        return String.format("m1 : name=%s, age=%d, photo=%s", name, age, photo.getOriginalFilename());
    }  
}







