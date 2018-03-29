package step11.ex12;

public class Exam04 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        // m1과 m2는 같은 값을 보유하고있다.
        // 하지만 서로 다른 인스턴스.
        
        System.out.println(m1==m2);
        System.out.printf("%d %d\n", m1.hashCode(), m2.hashCode());
        System.out.printf("%s %s\n", m1.toString(), m2.toString());
        System.out.printf("%b\n", m1.equals(m2));
        System.out.println("-----------------------------------------");
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        
        System.out.println(s1==s2);
        System.out.printf("%d %d\n", s1.hashCode(), s2.hashCode());
        System.out.printf("%s %s\n", s1.toString(), s2.toString());
        System.out.printf("%b\n", s1.equals(s2));

    }
}
