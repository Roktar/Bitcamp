package step15.ex2;
// 직접 인터페이스를 구현하는 것보다는 추상클래스를 상속 받기
public class Exam04 extends Exam03 {
    @Override
    public void service() {
        // TODO Auto-generated method stub
        
    }
    // Exam03에서는 service를 제외한 다른 규칙들을 정의했다.
    // 그렇기때문에 Exam03을 상속받는 04는 남은 service만 정의하면 된다.
}
