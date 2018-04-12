package step22.ex7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileout = new FileOutputStream("temp/test7.data");
        
        // 기존의 파일 아웃풋 스트림 객체에 문자,정수,부울값을 읽는 장신구(decorator) 부착
        DataOutputStream out = new DataOutputStream(fileout);
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
       out.writeUTF(member.name);
       out.writeInt(member.age);
       out.writeBoolean(member.gender);
        
        out.close();
        System.out.println("기록완료!");
    }
}
