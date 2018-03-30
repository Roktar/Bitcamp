package step12.ex6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Exam02_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("임꺽정", 30);
        Member m3 = new Member("유관순", 16);
        Member m4 = new Member("안중근", 20);
        Member m5 = new Member("윤봉길", 25);
        
        HashMap map = new HashMap();
        map.put("s01", m1);
        map.put("s02", m2);
        map.put("s03", m3);
        map.put("s04", m4);
        map.put("s04", m5);
        
        // 해쉬맵에서 키 목록 꺼내기
        
        Set keys = map.keySet();
        
        // 키 목록을 보유한 set 객체에서 값을 꺼내느 ㄴ방법
        // 1) iterator
        Iterator 키를_꺼내주는_객체 = keys.iterator();
        
        while(키를_꺼내주는_객체.hasNext()) {
            Object key = 키를_꺼내주는_객체.next();
            System.out.println( map.get(key) );
        }
        System.out.println();
        // 2) 배열 사용
        Object[] obj = keys.toArray();
        for(Object key : obj) {
            System.out.println(map.get(key));
        }
        // 3) 만약 컬렉션 객체가 java.util.Collection 규칙을 따라 만든 클래스인 경우,
        //    바로 foreach문을 사용할 수 있다.
        //    그냥 저 클래스를 상속받느냐라고 생각하면 된다.
        for(Object key : keys)
            System.out.println(map.get(key));
    }
}
