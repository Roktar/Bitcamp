package step22.ex9;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

// serializa 인터페이스와 UID 변수

public class Exam04_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileout = new FileOutputStream("temp/test9_5.data");
        BufferedOutputStream bufout = new BufferedOutputStream(fileout);
        ObjectOutputStream out = new ObjectOutputStream(bufout);
       
       Score s = new Score();
       s.name="홍길동";
       s.kor=99;
       s.eng=80;
       s.math=92;
       s.compute();
       out.writeObject(s);
       
        out.close();
        System.out.println("기록완료");
    }
}
