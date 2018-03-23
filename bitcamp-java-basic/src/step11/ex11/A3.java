package step11.ex11;

public class A3 extends A {
    int age;
    
    // 상속받은 메서드가 서브클래스의 목적에 맞지 않다면 서브클래스의 역할에 맞춰서
    // 재정의 할 수 있다.
    // 부모의 메소드를 덮어쓰기(Override)하여 자식클래스에 필요한 기능으로 바꾼다.
    // 이 메소드를 호출하는 개발자 입장에서는 A클래스와 같은 메소드를 사용하기 때문에 별다른 구분없이 이해할 수 있다.
    void print() {
        System.out.printf("'%s(%d)'님 반갑습니다.\n", this.name, this.age);
    }
}
