package step19.ex9;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
// 의존 객체를 스스로 만들기

// 의존 객체(Dependency Object) : 작업을 수행하기 위해 사용해야만 하는 객체.
// Car 클래스의 경우, Engine클래스가 Car의 의존 객체이다.
// Car의 move를 사용하려면 engine가 필요하다.

// 의존 객체는 일반적으로 그 객체를 사용하는 쪽에서 생성한다.
// 그러므로 Car 클래스에서 Engine객체를 사용하기에 Car의 생성자에서 Engine 객체를 생성하ㅣㄴ다.
public class Exam15 {
    public Exam15() {
        System.out.println("Exam15 생성");
    }
    public static void main(String[] args) throws Exception {
        ApplicationContext10 iocContainer = new ApplicationContext10("step19.ex9");
        Car car = (Car) iocContainer.getBean("car"); // 어노테이션 지정할 때 줬던 값으로 찾을 수 있다.
        //car2.move();
    }
}
