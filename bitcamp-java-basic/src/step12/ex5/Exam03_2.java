package step12.ex5;

import java.util.HashSet;
import java.util.Iterator;

public class Exam03_2 {
    static class Member {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

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

        @Override
        public String toString() {
            return  "[" + name + ", " + age + "]";
        }
    }
    
    public static void main(String[] args) {
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("임꺽정", 20);
        Member m3 = new Member("유관순", 20);
        Member m4 = new Member("안중근", 20);
        Member m5 = new Member("유관순", 20);
        
        HashSet set = new HashSet();
        
        set.add(m1);
        set.add(m2);
        set.add(m3);
        set.add(m4);
        set.add(m5);
        
        print(set);
    }
    
    static void print(HashSet list) {
        Object[] arr = list.toArray();
        
        for(Object value : arr )
            System.out.print(value + ", ");
        System.out.println();
    }
}
