package step12.ex1;

import java.util.ArrayList;

public class Exam02_4 {
    // hequals 오버라이딩
    static class Member {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
/*        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }*/

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Member other = (Member) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
        // 인스턴스가 달라도 name, age값이 같으면 true를 반환한다.
        // 즉, contains 함수의 결과도 true가 된다.

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return String.format("[%s, %d]", this.name, this.age);
        }
    }
    
    
    public static void main(String[] args) {

        Member s1 = new Member("홍길동", 20);
        Member s2 = new Member("임꺽정", 30);
        Member s3 = new Member("유관순", 16);
        Member s4 = new Member("임꺽정", 30);
        
        ArrayList list = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        print(list);
        
        // 오버라이딩을 안했기때문에 같은 값을 갖더라도 인스턴스가 다르면 해시값이 다르고
        // equals함수의 리턴값도 false가 된다.
        // 그렇기에 contains함수로 s4 객체와 같은 객체가 있는 지 테스트해본다.
        // 그리고 그 결과는 false가 나올 것이다. (인스턴스만 비교하므로 인스턴스는 다르다.)
        System.out.println(list.get(1).equals(s4));
    }
    
    public static void print(ArrayList list) {
        for (int i=0; i < list.size(); i++)
            System.out.print(list.get(i) + ", ");
        System.out.println();
    }
}
