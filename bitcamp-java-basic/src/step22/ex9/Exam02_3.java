package step22.ex9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

// Serialize 되어 출력된 데이터를 읽어 다시 원래의 객체로 돌리기

public class Exam02_3 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_3.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);
        
        Member2 member = (Member2) in.readObject();
        // Object형식으로 불러오기때문에 해당 객체 형식으로 캐스팅해준다.

        in.close();
        
        System.out.println(member);
    }
}
