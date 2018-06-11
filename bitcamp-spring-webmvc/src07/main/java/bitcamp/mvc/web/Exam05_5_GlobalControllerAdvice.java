package bitcamp.mvc.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// 모든 페이지 컨트롤러에 대해 조언을 수행하는 클래스 정의
// 다음 어노테이션을 붙이면 페이지 컨트롤러를 실행할 때마다 호출될 것이다.
@ControllerAdvice
public class Exam05_5_GlobalControllerAdvice {
    // 글로벌 컨트롤러 어드바이스 객체에 따로 프로퍼티 에디터를 초기화시키는 메소드를 정의해뒀기때문에 다음 메소드를 이 컨트롤러에 등록하지 않아도 됨.
    @InitBinder
    public void customEditor(WebDataBinder binder) {
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue( Date.valueOf(text) );
            }
        });
    }
}
