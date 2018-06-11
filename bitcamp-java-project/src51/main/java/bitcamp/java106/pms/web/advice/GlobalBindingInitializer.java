package bitcamp.java106.pms.web.advice;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import bitcamp.java106.pms.web.ClassroomController;
import bitcamp.java106.pms.web.TaskController;
import bitcamp.java106.pms.web.TeamController;

// 해당 클래스의 내용을 적용시킬 클래스를 한정한다.
@ControllerAdvice(assignableTypes= {TeamController.class, ClassroomController.class, TaskController.class})
public class GlobalBindingInitializer {
    // 컨트롤러 어드바이스 메소드를 등록하면 각 페이지 컨트롤러마다 따로 등록할 필요가 없다.
    @InitBinder
    public void customEditor(WebDataBinder binder) {
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(Date.valueOf(text));
            }
        });
    }
}
