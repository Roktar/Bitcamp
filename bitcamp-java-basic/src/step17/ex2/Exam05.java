package step17.ex2;
// static member와 import

// 스태틱 멤버를 클래스 이름을 지정하지 않고 바로사용하고싶을 때,
// 아래와 같이 해당 스태틱 멤버가 들어있는 클래스를 컴파일러에게 알려줄 것
import static step17.ex2.Category2.appliance.*;

public class Exam05 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        
        p.category = TV; // 원래 쓰려면 Category2.appliance.TV로 해야하지만
                         // 상단에 static으로 import해놨기때문에 
                         // 해당 클래스변수의 위치를 컴파일러에게 알려줬다. 그래서 사용가능
        p.name = "울트라비전 뷰";
        p.price = 200000;
    }
}
