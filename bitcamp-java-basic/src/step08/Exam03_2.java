package step08;

public class Exam03_2 {
    
    static class A {
        int val;
        
        static void m1() {
            //this.val = 100;
        }
        
        void m2() {
            this.val = 100;
        }
        
        void m3() {
            val = 300; // local variable
            // this.val = 300; 과 같음.
        }
        
        void m4(int val) {
            val = 200; // local variable
            this.val = 300; // instance variable
        }
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        A.m1();
        A obj1 = new A();
        obj1.m2();
        System.out.println(obj1.val);
        
        
    }

}
