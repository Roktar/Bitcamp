package step11.ex14;
// 다형적 변수와 오버라이딩

public class Exam01 {
    
    public static void main(String[] args) {
        A a = new A();
        A2 a2 = new A2();
        
        a.m();
        a2.m();
        
        A p = a2;
        a2.m();
    }
    
}
