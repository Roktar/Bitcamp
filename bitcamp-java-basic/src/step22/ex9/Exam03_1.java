package step22.ex9;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

// serializa 인터페이스와 UID 변수

public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileout = new FileOutputStream("temp/test9_4.data");
        BufferedOutputStream bufout = new BufferedOutputStream(fileout);
        ObjectOutputStream out = new ObjectOutputStream(bufout);
        
        Member3 member = new Member3();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
       out.writeObject(member);
       // Member3는 Serializable을 구현했기때문에 버전 번호도 함께 출력된다.
        
        out.close();
        System.out.println("기록완료");
    }
}
