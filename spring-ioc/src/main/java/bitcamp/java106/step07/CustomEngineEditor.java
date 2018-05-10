package bitcamp.java106.step07;
// 사용자 정의 프로퍼티 에디터 생성
import java.beans.PropertyEditorSupport;

public class CustomEngineEditor extends PropertyEditorSupport {

    // 스프링 IoC 컨테이너가 String 타입의 프로퍼티 값을 다른 타입의 값으로 바꿀 때 호출하는 메소드
    public void setAsText(String text) throws IllegalArgumentException {
        String[] values = text.split(",");
        Engine engine = new Engine();
        engine.setMaker(values[0]);
        engine.setValve(Integer.parseInt(values[1]));
        engine.setCylinder(Integer.parseInt(values[2]));
        this.setValue(engine);
    }
}
