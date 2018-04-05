package step18.ex1;

public class Exam05 {
    
    static class A {
        static void m() {}

        static {
            System.out.println("클래스 로딩");
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex1.Exam05$A");
        
        A obj  = (A) clazz.newInstance();
        obj.m();
    }
}
