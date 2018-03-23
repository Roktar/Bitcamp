package step11.ex10;

public class B extends A {
    static void m(int a, int b, int c) {
        System.out.println("int, int, int");
    } // 이것도 메소드 오버로딩임. 매개변수 2개짜리 plus만 있었는데 3개짜리 plus를 만들어서 기존거랑 매개변수에 차이가 발생.
    // 부모클래스에 있는 것도 자식에서 오버로딩이 가능.
}
