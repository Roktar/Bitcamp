package step08;

public class Exam06_5 {

    static class A {
        static float pi;
        int b;
        
        static {
            pi = 3.14159f;
        }
        
        static float area(int r) {
            return 2 * pi * r;
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(A.area(25));
    }
}
