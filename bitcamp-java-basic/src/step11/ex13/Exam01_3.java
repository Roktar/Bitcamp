package step11.ex13;

public class Exam01_3 {
    
    public static void main(String[] args) {
        // private 설정으로 인해 다른 클래스는 해당 인스턴스 변수에 접근이 불가능하다.
        Customer2 c1 = new Customer2();
        c1.name = "홍길동";
        c1.age = 300;
        c1.weight = 100;
        c1.height = -50;
        // 해결책으로는 이 클래스에서 제공하는 메소드를 사용한다.
        
    }
    
}
