package step12.ex1;

import java.util.ArrayList;

public class Exam02_3 {
    // hashcode, equals 오버라이딩x
    static class Member {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

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
