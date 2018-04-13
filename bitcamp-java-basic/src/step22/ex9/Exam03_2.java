package step22.ex9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_4.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);
        
        // test9_3.data 파일을 읽기 전,
        // Member2 클래스에 전화번호를 저장할 수 있는 인스턴스 변수를 추가
        
        Member3 member = (Member3) in.readObject();
        // 2_4와 다른점
        // Member3 객체의 시리얼데이터를 출력한 다음, Member3를 변경하더라도데이터를 읽는데 실행오류가 발생하지않음
        // why? 클래스의 버전 번호가 같기때문이다.
        // 기존 데이터에 그저 새로운 데이터의 변수만 추가했다. => 즉 기존 데이터는 문제가 없다는 얘기. 그래서 에러 미발생.

        in.close();
        
        System.out.println(member);
    }
}
