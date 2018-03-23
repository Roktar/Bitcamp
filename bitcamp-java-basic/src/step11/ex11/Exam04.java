package step11.ex11;
// 오버라이딩 문법 검사

public class Exam04 {

    public static void main(String[] args) {
        B2 obj = new B2();
        
        // 부모타입의 매개변수와 맞지 않아 오버로딩이 됫다.
        obj.m(100);
        
        // 개발자들의 이런 실수가 많이 발생되어 자바에서는 오버라이딩 여부를 검사하는 특별한 문법을 추가.
        
        
    }
}
