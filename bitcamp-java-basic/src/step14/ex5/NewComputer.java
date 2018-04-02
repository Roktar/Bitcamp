package step14.ex5;

public class NewComputer implements Computer {
// 새 컴퓨터를 만들 때, 기존 규칙만을 따라도 되고
// 새로 추가한 규칙을 정의해도 된다.
    @Override
    public void compute() {
        // TODO Auto-generated method stub
        
    }
    
    // 나중에 추가한 touch 메소드를 구현하는 것은 선택이다.
    public void touch() {
        System.out.println("터치 기능 추가");
    } // 오버라이딩
    
}
