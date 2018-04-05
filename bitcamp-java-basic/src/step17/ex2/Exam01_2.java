package step17.ex2;

// 각각의 상수를 별도의 클래스로 묶어 관리하고있다. 물론 이건 나쁜 건 아님.
// 하지만 클래스 파일이 늘어나게된다. 즉, 상수를 묶어놓은 클래스를 관리하는 것이 번거로워졌다는 점이다.
public class Exam01_2 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        
        p.category = Appliance.TV;
        p.name = "울트라비전 뷰";
        p.price = 200000;
        
        p.category = Book.EASSY;
        p.category = Computer.MOUSE;
    }
}
