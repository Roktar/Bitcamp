package step22.ex9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam02_4 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_3.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);
        
        // test9_3.data 파일을 읽기 전,
        // Member2 클래스에 전화번호를 저장할 수 있는 인스턴스 변수를 추가
        
        Member2 member = (Member2) in.readObject();
        // 현재 9_3.data에는 tel 변수가 없는 구버전의 member2 정보를 가지고있다.
        // 하지만 불러올 때는 tel이 추가된 신버전의 member2를 가져오려고 한다.
        // 즉 버전이 맞지않아 호환이 되지 않으며, 구버전과 신버전은 양립할 수 없다.

        in.close();
        
        System.out.println(member);
    }
}
