package step12.ex6;
// 제너릭 

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Exam04_1 {

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
        //map.put("s04", m4);
        //map.put("s04", m5);
        
        

    }
}
