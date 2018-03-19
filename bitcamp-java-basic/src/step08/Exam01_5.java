package step08;



public class Exam01_5 {
    
    static class A {
        static int v1;
        int v2;
    }

    public static void main(String[] args) {
        A.v1 = 100;
        // A.v2 = 200; // 이건 인스턴스 변수라서 객체 생성 먼저 해야함.
        
        A p = new A();
        p.v2 = 200;
        //A.v2 = 200; // 레퍼런스로 참조해야함.
        
        A p2 = new A();
        p2.v2 = 300;
        
        System.out.printf("A.v1 = %d,  p.v2 = %d, p2.v2 = %d", A.v1, p.v2, p2.v2);
    }
}
