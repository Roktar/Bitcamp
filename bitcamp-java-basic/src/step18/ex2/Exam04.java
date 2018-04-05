package step18.ex2;
// 클래스 정보 추출 - 중첩클래스 정보
public class Exam04 {
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
        
        private class G {}
        
        protected class H {}
        
    }
    

    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex2.Exam04$A");
        
        // 특정 클래스의 모든 내부클래스, 인터페이스 정보를 가져온다.
        Class[] nestedList = clazz.getDeclaredClasses();
        
        for(Class nested : nestedList)
            System.out.println(nested.getName());
        
        
    } 
}
