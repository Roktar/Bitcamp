package step17.ex2;
// static member와 import

// 스태틱 멤버를 클래스 이름을 지정하지 않고 바로사용하고싶을 때,
// 아래와 같이 해당 스태틱 멤버가 들어있는 클래스를 컴파일러에게 알려줄 것
import step17.ex2.Category2.appliance.*;

public class Exam04 {
    public static void main(String[] args) {
        Product p = new Product();
        
        p.category = TV; // static을 안써서 에러남.
        
        p.name = "울트라비전 뷰";
        p.price = 200000;
    }
}
