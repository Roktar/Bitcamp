package step11.ex11;

public class B3 extends B {
    // 오버라이딩 문법
    // => 메소드명, 파라미터 형식, 리턴 타입이 같아야한다./
    // => 파라미터의 이름은 달라도 상관없다.
    
    @Override
    void m(int x) {
        System.out.println("B2의 m()");
    }
}
