package step08;
// class variable

public class Exam01_3 { 
    static class A {
        static int v1;
        static boolean v2;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        A.v1 = 100;
        A.v2 = true;
        
        System.out.printf("%d %b", A.v1, A.v2);
    }
}