package step14.ex6;
// 인터페이스 간접구현 확인
public class Exam03 {
    public static void main(String[] args) {
        A r1 = new Exam01();
        A r2 = new Exam02(); // OK, 직접적으로 A를 구현하는 것이 아니지만
                             // A를 구현한 Exam01을 상속받았기때문
    }
}
