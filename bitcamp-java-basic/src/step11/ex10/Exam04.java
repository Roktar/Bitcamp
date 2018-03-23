package step11.ex10;

public class Exam04 {
    public static void main(String[] args) {
     B.m();// 부모클래스의 m 호출
     B.m(1,2,3); // 자식클래스의 m 호출
     // => 위도 오버로딩임.
    }
}
