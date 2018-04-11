package step22.ex4;

import java.io.FileInputStream;
// 파일을 읽고 객체로 만들기

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream("temp/test4_2.data");
        
        Member member = new Member();
        
        // 이름
            member.name = in.readUTF();
        // 나이
            member.age = in.readInt();
        // 성별
            member.gender = in.readBoolean();
        
         System.out.println(member.toString());

    }
}
