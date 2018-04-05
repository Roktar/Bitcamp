package step18.ex2;
// 클래스 정보 추출 - 중첩클래스 정보
public class Exam03 {
    static class A {
        static class B{
            
        } // static nested class
        
        class C {
            
        } // non-static 
        
        public void m() {
            class D {}
            // local class
        }
        
        public void m2() {
            Object obj = new Object() {}; // anonymous
        }
        
        public static class E {
            
        }
        
        public class F {}
        
    }
    

    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex2.Exam03$A");
        
        // public으로 지정된 클래스의 정보를 가져옴.
        Class[] nestedList = clazz.getClasses();
        
        for(Class nested : nestedList)
            System.out.println(nested.getName());
        
        
    } 
}
