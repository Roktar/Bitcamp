package step13.ex1;

import java.util.ArrayList;
// 제너릭 미지정
public class Exam01_1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        // 기본적으로 Object 타입의 객체를 다루는 것으로 간주한다.
        
        list.add(new Member("홍길동", 20));
        list.add(new String("HELLO"));
        list.add(new Integer(100));
        
        // 값을 꺼낼때는 보통 해당클래스로 형변환을 한 후에 사용한다.
        // why? get 함수의 반환타입이 오브젝트다.
        Member member = (Member) list.get(0);
        System.out.println(member.name);
        System.out.println(member.age);
        
    }
}
