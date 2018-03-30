package step13.ex1;

import java.util.HashMap;

// 제너릭 미지정
public class Exam01_4 {
    public static void main(String[] args) {
        //제너릭 정복 ㅏ필요한 클래스 사용 시에는 데이터 타입을 알려줘야한다.
        //제너릭에 아무런 데이터 타입의 정보를 주지않는 경우 컴파일러가 경고를 띄운다.
        //무시해도 실행에 문제는 없고 자동적으로 Object 형식으로 사용된다.
        HashMap map = new HashMap<>(); //Object 형식의 키, 값을 다룬다.
        
        // 하지만 다음과 같이 명확하게 타입을 지정해주는 편이 더 좋다.
        // => 개발자에게 어떤 타입의 키와 밸류를 저장할 것인지를
        HashMap<Object, Object> map2 = new HashMap<>();
        
        HashMap<String, Member> map3 = new HashMap<>();
        map3.put("aaa", new Member("홍길동", 20 ));
        
        Member m = map3.get("aaa");

    }
}
