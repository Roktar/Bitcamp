package step18.ex2;
// 클래스 정보 추출 - 패키지 정보
public class Exam06 {
    static interface A {}
    static interface B {}
    static interface C {}
    static class D implements A, B, C {}

    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex2.Exam05$D");
        
        // 해당 클래스가 구현한 인터페이스 정보를 가져온다.
        Package nestedList = clazz.getPackage();

        System.out.println(nestedList.getName());

    } 
}
