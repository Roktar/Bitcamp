package step12.ex6;
// 사용자 정의 타입을 key로 사용할 경우
import java.util.HashMap;

public class Exam01_2 {
    static class MyKey {
        String major;
        int no;
        
        public MyKey(String major, int no) {
            this.major = major;
            this.no = no;
        }

        @Override
        public String toString() {
            return "MyKey [major=" + major + ", no=" + no + "]";
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("임꺽정", 30);
        Member m3 = new Member("유관순", 16);
        Member m4 = new Member("안중근", 30);
        Member m5 = new Member("윤봉길", 25);

        MyKey k1 = new MyKey("컴공", 1);
        MyKey k2 = new MyKey("컴공", 2);
        MyKey k3 = new MyKey("컴공", 3);
        MyKey k4 = new MyKey("컴공", 4);
        MyKey k5 = new MyKey("컴공", 5);
        
        HashMap map = new HashMap();
        map.put(k1, m1);
        map.put(k2, m2);
        map.put(k3, m3);
        map.put(k4, m4);
        map.put(k5, m5);

        System.out.println(map.get(k1));
        System.out.println(map.get(k2));
        System.out.println(map.get(k3));
        System.out.println(map.get(k4));
        System.out.println(map.get(k5));
        
        MyKey k6 = new MyKey("컴공", 3); // k3와 같은 값을 지님, 하지만 인스턴스가 다르다.
        System.out.println(map.get(k6));
        // 결국 equals 함수를 사용하며 이는 결국 인스턴스의 주소를 사용한다는 의미가 된다.

        
    }
}
