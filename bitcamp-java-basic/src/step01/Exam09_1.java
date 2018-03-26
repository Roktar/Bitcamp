package step01;

public class Exam09_1 {
    
    int i; // instance variable, 인스턴스의 주소가 있어야 사용가능.
    
/*    class Score {
        String name;
        int kor, eng, math, sum;
        float avg;
    }*/    
    static class Member /*extends Object*/ {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
/*        Exam09 a = new Exam09();
        Score obj = a.new Score(); // inner class에 new를 쓸 때는 이렇게 쓴다.
*/        // 스태틱 멤버는 인스턴스 멤버에 접근 불가능함.

        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        
        if(m1 == m2)
            System.out.println("m1 == m2");
        else
            System.out.println("m1 != m2");
        
        System.out.println(m1.equals(m2));

        System.out.print(m1 + ", " +m2);
        
    }
}
