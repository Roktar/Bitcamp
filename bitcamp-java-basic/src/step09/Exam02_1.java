package step09;
// String 클래스의 인스턴스 메소드 활용

public class Exam02_1 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String s1 = new String("Hello");
        char c = s1.charAt(1);
        System.out.println(c);
        
        //같은 문자열인지 비교, 단 아스키코드값으로 연산하는 듯.
        System.out.println(s1.compareTo("Helli"));
        System.out.println(s1.compareTo("Hello"));
        System.out.println(s1.compareTo("Hellu"));
        
        System.out.println( (int)'i' - (int)'o'  );
        
        // 특정 문자열에 특정 문자열이 존재하는 지 찾음.
        System.out.println(s1.contains("H"));
        System.out.println(s1.contains("E"));
        
        // 두 문자열을 연결
        String s2 = s1.concat(", World!");
        
        System.out.println(s1); // 기존 문자열을 사용해서 새로운 문자열을 만든다.
        System.out.println(s2);
        
        // 두 인스턴스에 들어있는 문자열이 같은 지 비교.
        System.out.println(s1.equals("asd"));
        System.out.println(s1.equals("Hello"));
        
        // 인스턴스에 들어있는 각 문자를 바이트 배열에 저장할 때,
        // 인코딩 문자집합을 지정하지않으면 기본값으로 JVM의 기본 문자집합으로 인코딩함.
        // JVM은 기본적으로 UTF-8 문자표를 사용한다.
        String s3 = new String("ABC가각");
        byte[] bytes = s3.getBytes();
        for(int i=0; i<bytes.length; i++)
            System.out.printf("%x, ", bytes[i]);
        System.out.println();
        bytes = s3.getBytes("EUC-KR");
        for(int i=0; i<bytes.length; i++)
            System.out.printf("%x, ", bytes[i]);        
        System.out.println();

        // String 클래스에도 특정 인스턴스가 아닌 일반목적으로 문자열을 다룰 수 있는 메소드 제공
        // 즉, 클래스 메소드를 제공한다.
        
       // 형식을 갖춘 문자열 만들기
        String s4 = String.format("%s님, 반갑습니다.", "홍길동");
        System.out.println(s4);
        
        // 구분자와 문자열들을 파라미터로 받아서 연결한 새 문자열을 만든다.
        String s5 = String.join(",", "Hello", "World", "This");
        System.out.println(s5);
        
        // primitive 값을 문자열로 만든다.
        String s6 = String.valueOf(true);
        String s7 = String.valueOf(3.14f);
        String s8 = String.valueOf(100);
        System.out.printf("%s %s %s", s6, s7, s8);
        
        
    }           

}
