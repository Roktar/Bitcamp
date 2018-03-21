package step09;

public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        
        if(s1 == s2)
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        
        String s3 = new String(new char[] {'H', 'e', 'l', 'l', 'o'});
        System.out.printf("%s %s %s\n", s1, s2, s3);
        
        byte[] bytes = { (byte)0xb0, (byte)0xa1, (byte)0xb0, (byte)0xa2, (byte)0xb6, (byte)0xca, (byte)0xb6, (byte)0xcb };
         String s4 = new String(bytes);
        // 한글 깨짐 : EUC-KR 코드 값이 들어있는 바이트배열이 제대로 유니코드 배열로 저장되지않았기때문이다.
        // 이 생성자는 바이트 배열에 들어있는 값이 ISO-8859-1이라고 간주한다.
        
        String s5 = new String(bytes, "EUC-KR");
        // 그래서 출력포맷을 EUC-KR이라고 확실하게 지정해준다.
        System.out.println(s5);
    }
}
