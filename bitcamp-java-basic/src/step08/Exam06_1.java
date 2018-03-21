package step08;

public class Exam06_1 {

    static class A {
        int a = 100;
        
        {
            a = 150;
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        A d = new A() {
            {
                System.out.println(a = 250);
            }
        };
        
        
    }
}
