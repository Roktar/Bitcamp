package step18.ex1;

public class Exam02 {
    static class A {
        static int s_var;
        int i_var;
        
        static void s_m() {}
        void i_m() {}
        
        static {
            System.out.println("클래스 로딩");
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("step18.ex1.Exam02$A");
        
    }
}
