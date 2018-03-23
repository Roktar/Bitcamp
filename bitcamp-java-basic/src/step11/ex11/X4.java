package step11.ex11;

public class X4 extends X3 {
    @Override
    void m1() {
        System.out.println("X4의 m1()");
    }
    
    void test() {
        this.m1(); // 현재 클래스의 m1을 수행
        super.m1(); // 부모클래스의 m1을 수행. 단, 직전 부모클래스의 override된 클래스의 것을 사용
        // super.super.m1(); // 이렇게는 못씀
        
        this.m2(); // 현재 클래스의 m2를 수행. 단, 재정의 안했으면 부모클래스단에서 재정의된 것을 가져온다.
        super.m2(); // 부모클래스의 m2를 수행. 단, 직전 부모클래스의 override된 클래스의 것을 사용
    }
}
