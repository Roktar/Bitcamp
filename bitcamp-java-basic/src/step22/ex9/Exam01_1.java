package step22.ex9;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
// 버퍼미적용
public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileout = new FileOutputStream("temp/test9.data");
        DataOutputStream out = new DataOutputStream(fileout);
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        long start = System.currentTimeMillis();
        
        for(int i=0; i<100000; i++) {
           out.writeUTF(member.name);
           out.writeInt(member.age);
           out.writeBoolean(member.gender);
        }
        
        long end = System.currentTimeMillis();
        
        out.close();
        System.out.println("기록완료! - 걸린시간 : " + (end-start) + " ms");
    }
}
