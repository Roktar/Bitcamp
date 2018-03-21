package step08;
// 자동적으로 초기화도ㅣ는 변수의 예
public class Exam05_1 {
    
    static class A {
        static int a;
        int b;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(A.a);
        A obj = new A();
        System.out.println(obj.b);
        
        
    }
}
