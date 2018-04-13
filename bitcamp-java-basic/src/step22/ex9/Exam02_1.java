package step22.ex9;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileout = new FileOutputStream("temp/test9.data");
        BufferedOutputStream bufout = new BufferedOutputStream(fileout);
        ObjectOutputStream out = new ObjectOutputStream(bufout);
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
       out.writeObject(member);
       // 단, 여기서는 NotSerializableException이 뜬다.
       // => 인스턴스의 값을 자동으로 바이트배열로 만들 수 있도록 허가가 나지않았기때문에 불가능.
               
        out.close();
    }
}
