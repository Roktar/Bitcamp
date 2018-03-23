package step11.ex11;

public class D2 extends D {
    
    @Override
    void m() {
        System.out.println("D2의 m()");
    }
    
    void test() {
        // 오버라이딩 하기 전에 메서드를 호출하고싶은 경우에는 앞에 super를 쓴다.
        super.m();
    }
}
