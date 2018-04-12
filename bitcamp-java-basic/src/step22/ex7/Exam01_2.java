package step22.ex7;

import java.io.FileInputStream;
// 파일을 읽고 객체로 만들기
import java.io.FileOutputStream;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream filein = new FileInputStream("temp/test7.data");
        DataInputStream in = new DataInputStream(filein);
                
        Member member = new Member();
        
        member.name = in.readUTF();
        member.age = in.readInt();
        member.gender = in.readBoolean();
        
        System.out.println(member);
        
    }
}
