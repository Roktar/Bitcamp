package bitcamp.java106.step07;
// 사용자 정의 프로퍼티 에디터 생성
import java.beans.PropertyEditorSupport;

public class CustomDateEditor extends PropertyEditorSupport {

    // 스프링 IoC 컨테이너가 String 타입의 프로퍼티 값을 다른 타입의 값으로 바꿀 때 호출하는 메소드
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("call CustomDateEditor.setAsText(" + text + ")");
        // 파라미터로 넘어온 String 타입의 프로퍼티값을 원하는 타입의 값으로 바꾼 후 내부에 저장.
        // ==> 스프링 IoC 컨테이너는 이 값을 꺼내서 객체에 주입한다.
        this.setValue(java.sql.Date.valueOf(text));
    }
    
    @Override
    public void setValue(Object value) {
        System.out.println("call CustomDateEditor.setValue(" + value + ")");
        super.setValue(value);
    }
    
    public Object getValue() {
        System.out.println("call CustomDateEditor.getValue()");
        return super.getValue();
    }
}
