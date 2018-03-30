package step12.ex6;
// hash Map과 hashTable
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Exam03_2 {

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
        map.put("s05", m5);

        Set keys = map.keySet();
        map.remove("s01");
        map.remove("s02");
        map.remove("s03");

        // set객체를 통해 키를 꺼낼 때, 그 순간의 해쉬셋에 있는 키를 꺼낸다.
        // 즉, keySet 함수를 호출할 때 모든 키 목록을 미리 만들어 리턴하지않는다.
        for(Object value : keys) {
            System.out.printf("%s\n", value);
        }
        
    }
}
