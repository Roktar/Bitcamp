package step18.ex1;

// Reflection API

class A {
    static int i;
    static void m() {i=100;}
    static {
        System.out.println("클래스 로딩");
    }
}

public class Exam01 {
    public static void main(String[] args) throws Exception {
        //A.i = 100; //클래스 로딩된걸 확인
        //A.m(); // 로딩 확인
        //new A(); // 로딩 확인
        
        A obj = null; // 레퍼런스만 생성된 거임. 그래서 클래스 로딩은 안됨
        A[] arr = new A[100]; // 인스턴스를 생성한 게 아니라 클래스 로딩이 안됨.
        
        Class.forName("step18.ex1.A");
    }
}
