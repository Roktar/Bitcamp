package step21.ex4;
// 예외 던지고 받기
public class Exam01 {
    static void m1() {
        m2();
        System.out.println("call m1");
    }
    
    static void m2() {
        m3();
        System.out.println("call m2");
    }
    
    static void m3() {
        m4();
        System.out.println("call m3");
    }
    
    static void m4() {
        System.out.println("call m4");
    }
    
    public static void main(String[] args) {
        m1();
    }
}
