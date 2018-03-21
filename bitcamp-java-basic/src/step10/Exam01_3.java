package step10;
// String compare
public class Exam01_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String s1 = new String("Hello");
        String s2 = s1.replace('l', 'x');

        System.out.printf("%s | %s\n", s1, s2 );
        
        String s3 = s1.concat(", World!");
        System.out.printf("%s | %s\n", s1, s3);
        
        // s1 문자열을 써도 원본에는 변함이 없음을 알 수 있다.
        
        // StringBuffer
        StringBuffer buf = new StringBuffer("Hello");
        buf.replace(2, 4, "xx");
        System.out.printf("%s\n", buf);
        
        StringBuffer b1 = new StringBuffer("Hello");
        StringBuffer b2 = new StringBuffer("Hello");
        
        System.out.println( (b1.equals(b2) ? "equals" : "!equals") );
        System.out.println( (b1.toString().equals(b2.toString()) ? "equals" : "!equals") );
       
    }
}
