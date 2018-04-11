package step22.ex4;

import java.io.FileOutputStream;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        DataOutputStream out = new DataOutputStream("temp/test4_2.data");
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
        //out.write( String.format("%s,%d,%b", member.name, member.age, member.gender).getBytes("UTF-8") );
        
        // 이름
        out.writeUTF(member.name);
        
        // 나이
        out.writeInt(member.age);
        // 1바이트씩 기록
        
        // 성별
        out.writeBoolean(member.gender);
        
        out.close();
        System.out.println("기록완료!");
    }
}
