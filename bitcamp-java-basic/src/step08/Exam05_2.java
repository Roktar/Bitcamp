package step08;

public class Exam05_2 {
    
    static class A {
        static int a = 100; // 생성과 동시에 초기화
        int b = 200; // 생성과 동시에 초기화
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(A.a);
        A obj = new A();
        System.out.println(obj.b);
        int c = 300;
        System.out.println(c);
        
        
    }
}
