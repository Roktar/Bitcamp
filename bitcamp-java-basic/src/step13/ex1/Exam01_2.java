package step13.ex1;

import java.util.ArrayList;
// 제너릭 지정
public class Exam01_2 {
    public static void main(String[] args) {
        ArrayList<Member> list = new ArrayList<Member>();
        // 기본적으로 Object 타입의 객체를 다루는 것으로 간주한다.
        
        list.add(new Member("홍길동", 20));
        //list.add(new String("HELLO"));
        //list.add(new Integer(100));
        
        ArrayList<String> list2 = new ArrayList</*String*/>();
        ArrayList<String> list3;
        list3 = new ArrayList<>();
        
        Member member = list.get(0);
        // 제너릭을 지정하면 그와 관련된 함수의 타입 정보가 자동으로 변경된다. 즉, 그렇기때문에 형변환할 필요가 없다.


    }
}
