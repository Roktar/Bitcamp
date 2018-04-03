package step11.ex18;


// Car 클래스의 start, shutdown은 기본 기능이기때문에 하위에서는 모두 같은 기능을 한다.
// 하지만 run은 서브클래스마다 특징에 맞춰 재정의해야할 필요성이 있다.
// 서브클래스마다 재정의해야한다면 굳이 부모클래스에서 구현할 필요성이 없다.
// 따라서 메소드를 만들도록 강제하되 몸체만 선언한다. => 추상메소드

public class Exam01 {
    public static void main(String[] args) {

    }
}
