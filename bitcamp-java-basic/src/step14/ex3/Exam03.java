package step14.ex3;

public class Exam03 implements B, C, D{

    @Override
    public void m1() {
        // TODO Auto-generated method stub
        
    }

    @Override // B, D가 겹침
    public void m4() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void m3() {
        // TODO Auto-generated method stub
        
    }

    @Override // B, D가 겹침
    public void m2() {
        // TODO Auto-generated method stub
        
    }
    
    // B 인터페이스 입장에서 Exam03 클래스는 m2() 메소드를 구현했다.
    // D 인터페이스 입장에서도 Exam03 클래스는 m2() 메소드를 구현했다.
    // 각 인터페이스 입장에서 같은 메소드를 구현한 것이기때문에 상관없다.
    // => 처음부터 구현된 메소드가 아니었기때문에 상관없음.

}
