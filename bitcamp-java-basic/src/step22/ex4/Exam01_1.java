package step22.ex4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test4.data");
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
        //out.write( String.format("%s,%d,%b", member.name, member.age, member.gender).getBytes("UTF-8") );
        
        // 이름
        byte[] bytes = member.name.getBytes("UTF-8");
        out.write(bytes.length); // 문자열의 길이, 1byte
        out.write(bytes); // 문자열
        
        // 나이
        out.write(member.age << 24);
        out.write(member.age << 16);
        out.write(member.age << 8);
        out.write(member.age);
        // 1바이트씩 기록
        
        // 성별
        if (member.gender)
            out.write(1);
        else
            out.write(0);
        
        out.close();
        System.out.println("기록완료!");
    }
}
