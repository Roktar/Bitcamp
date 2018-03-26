package step01;

public class Exam09_3 {
    
    int i; // instance variable, 인스턴스의 주소가 있어야 사용가능.

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        // equals는 String 클래스단에서 Override했기때문에 값으로 비교를 해서 원하는 결과를 얻었다.

        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");
        
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        // sb1.equals(sb2)의 반환값은 false.
        // why? 스트링버퍼클래스는 equals를 override 안했기때문에 인스턴스의 주소만 비교한다.
    
    }
}
