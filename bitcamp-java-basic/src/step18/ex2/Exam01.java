package step18.ex2;
// 클래스 정보 추출 - 클래스명 추출하기
public class Exam01 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.lang.String");
        
        System.out.println(clazz.getSimpleName()); // String 추출
        System.out.println(clazz.getName()); // java.lang.String 추출
        System.out.println(clazz.getCanonicalName()); // java.lang.String
        System.out.println(clazz.getTypeName()); // java.lang.String
        
    } 
}
