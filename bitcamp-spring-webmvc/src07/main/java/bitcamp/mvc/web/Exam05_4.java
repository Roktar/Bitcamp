// 요청 핸들러의 파라미터 - 파라미터로 받을 수 있는 객체
package bitcamp.mvc.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.vo.Member;

@Controller 
@RequestMapping("/exam05_4") 
public class Exam05_4 {
   
    // 커스텀 프로퍼티 에디터 등록
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1 : %s, %s, %s", title, content, createdDate);
    }
    
    @GetMapping(value="m2")
    @ResponseBody
    public String m2(Member member) {
        return String.format("m2 : id=%s, email=%s, password=%s", member.getId(), member.getEmail(), member.getPassword());
    }
    
    // 객체를 만들 때는 @RequestParam을 붙여야한다.
    @GetMapping(value="m3")
    @ResponseBody
    public String m3(@RequestParam Member member) {
        return String.format("m3 : id=%s, email=%s, password=%s", member.getId(), member.getEmail(), member.getPassword());
    }
    
    // 위의 메소드가 실행되기 전에 아래 에디터가 먼저 실행이 된다.
    @InitBinder
    public void customEditor(WebDataBinder binder) {
        System.out.println("Exam05_4.customEditor");
        System.out.println(binder.getObjectName());
        // sql.Date로 바꿔주는 역할을 하는 에디터
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue( Date.valueOf(text) );
            }
        });
        
        // Member로 바꿔주는 역할을 하는 에디터
        binder.registerCustomEditor(bitcamp.mvc.vo.Member.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                String[] values = text.split(",");
                Member obj = new Member();
                obj.setId(values[0]);
                obj.setEmail(values[1]);
                obj.setPassword(values[2]);
                this.setValue(obj);
            }
        });
    }
}







