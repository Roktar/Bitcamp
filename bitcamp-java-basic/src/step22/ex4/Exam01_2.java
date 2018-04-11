package step22.ex4;

import java.io.FileInputStream;
// 파일을 읽고 객체로 만들기

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test4.data");
        
/*        byte[] bytes = new byte[150];
        int cnt = in.read(bytes);
        String s = new String(bytes);
        String[] sArray = s.split(",");
        
        System.out.println(sArray[0]);
        System.out.println(sArray[1]);
        System.out.println(sArray[2]);*/
        
        Member member = new Member();
        
        // 이름
        byte[] bytes = new byte[100];
        int cnt = in.read();
        member.name = new String(bytes, 0, cnt, "UTF-8");
        // 나이
        member.age = in.read() >> 24;
        member.age += in.read() >> 16;
        member.age += in.read() >> 8;
        member.age += in.read();
        
        // 성별
        if(in.read() == 1)
            member.gender = true;
        else
            member.gender = false;
        
        System.out.println(member.name);
        System.out.println(member.age);
        System.out.println(member.gender);
    }
}
