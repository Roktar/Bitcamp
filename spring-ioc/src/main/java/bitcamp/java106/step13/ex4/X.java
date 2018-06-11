package bitcamp.java106.step13.ex4;

import org.springframework.stereotype.Component;

@Component
public class X {
    public X() {
        System.out.println("X 객체 생성됨");
    }
    public int m1(int a, int b) {
        System.out.println("x.m1()");

        return (a/b);
    }
}
