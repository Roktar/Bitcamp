package step11.ex11;

public class Exam03 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A3 obj1 = new A3();
        obj1.name = "길동";
        obj1.age = 10;
        
        // A3 클래스에서는 A클래스의 print함수를 재정의했기때문에 다음 호출하는 메소드는 A3의 print가 된다.
        obj1.print();
    }

}
