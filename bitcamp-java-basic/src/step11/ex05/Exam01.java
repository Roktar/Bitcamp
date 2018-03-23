package step11.ex5;

public class Exam01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        
        B obj2 = new B();
        // B클래스의 설계도에 따라 힙 영역에 변수를 준비한다.
        obj2.v2 = 200;
        // B 클래스는 A클래스도 사용한다고 선언했기때문에 
        //A클래스의 설계도에 따라 A클래스에 선언된 인스턴스 변수도 생성된다.
        obj2.v1 = 100;
        System.out.printf("%d %d", obj2.v1, obj2.v2);
        
        A obj3 = new B();
        // 
    }
}
