package step10;
// String - "Hello" vs new String("Hello")
public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        //힙 영역에 String 인스턴스를 만든다.
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // 내용물의 동일 여부를 검사하지않고 무조건 인스턴스를 만든다.
        // 가비지가 되면 가비지컬렉터에 의해 제거된다.
        
        //String constant pool 영역에 String 인스턴스를 만든다.
        String s3 = "Hello";
        String s4 = "Hello";
        String s5 = "as";
        // 내용이 같으면 기존 인스턴스의 주소를 반환한다.
        // 즉 메모리 절약을 위해 중복 데이터를 갖는 인스턴스를 생성하지않는다.
        // 힙 영역의 상수풀에 생성되며 이 상수풀은 JVM과 함께 운명을 맞이한다.
        
        System.out.println( (s1 == s2 ? " == " : "!= ") );
        System.out.println( (s1 == s3 ? " == " : "!= ") );
        System.out.println( (s3 == s4 ? " == " : "!= ") );
    }

}
