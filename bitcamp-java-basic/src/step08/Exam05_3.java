package step08;
// 생성자로 초기화하기 
public class Exam05_3 {
    
    static class A {
        int a = 100; // 생성자 호출 전에 먼저 실행됨 
        
        A() {
            a = 200;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A obj = new A();
        System.out.println(obj.a);
        int c = 300;
        System.out.println(c);
        
        
    }
}
