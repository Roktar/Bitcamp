package step18.ex2;
// 클래스 정보 추출 - 클래스명 추출하기
public class Exam02 {
    static class A {
        
    }
    
    static class B extends A {
        
    }
    
    static class C extends B {
        
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex2.Exam02$C");
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass.getName()); // 슈퍼클래스 정보
        
        
    } 
}
