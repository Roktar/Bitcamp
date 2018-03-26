package step11.ex13;

import java.util.Calendar;

import step11.ex13.sub.C;

public class Exam02_3 extends C {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // 캘린더 생성자가 프로텍트로 되어있는 경우 : 직접 생성자 호출을 하지말라는 의미
        // 단, 개발자들이 이 클래스의 인스턴스를 만들 수 있도록 스태틱메소드를 제공한다. 
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        System.out.println(c1 == c2);
        // false가 나오는 걸 봐서는 singleton 패턴은 아니다.
        // 복잡한 캘린더 객체를 대신 생성해주는 팩토리메소드라고 볼 수 있겠다.
        // 생성자를 프로텍트걸고 대신 생성해주는 메소드 getInstance를 전체공개했다.
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

    }
}
