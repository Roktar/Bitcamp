package step08;

public class Exam02_1 {
    static class A {
        static void m1() { // class method
            System.out.println("m1()");
        }
        void m2() { // instance method
            System.out.println("m2()");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        A.m1();
        
        A obj1 = new A();
        A obj2 = null;
        
        obj1.m2();
        obj1.m1();// 가능하지만 지양할 것.
        
        //obj2.m2(); // 컴파일은 되나 실행은 오류이다.
        // obj2 변수에 들어있는 주소가 없기때문

    }

}
