package step01;

public class Exam09_2 {
    
    int i; // instance variable, 인스턴스의 주소가 있어야 사용가능.

    static class Member /*extends Object*/ {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Member))
                return false;
            
            Member other = (Member) obj;
            
            if( !this.name.equals(other.name) )
                return false;
            if( this.age != age)
                return false;
            
            return true;
        }
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
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
