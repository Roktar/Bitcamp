package step22.ex9;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileout = new FileOutputStream("temp/test9.data");
        BufferedOutputStream bufout = new BufferedOutputStream(fileout);
        ObjectOutputStream out = new ObjectOutputStream(bufout);
        
        Member2 member = new Member2();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
       out.writeObject(member);
       // Member2는 Serializable을 구현했기때문에 기록이 된다.
        
        out.close();
    }
}
