package step22.ex3;

import java.io.FileOutputStream;

// long값 출력
public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        long money = 400_0000_0000_0000L;
        
        // 4바이트를 온전하게 입력하는 방법
        // 1바이트를 입력하는 write를 4번 호출한다. 그러면 4바이트 입력이 됨
        // 단, 원하는 자릿수를 지정해줘야한다.
        out.write((int) (money >> 56));
        out.write((int) (money >> 48));
        out.write((int) (money >> 40));
        out.write((int) (money >> 32));
        out.write((int) (money >> 24));
        out.write((int) (money >> 16));
        out.write((int) (money >> 8));
        out.write((int) money);

        out.close();
        System.out.println("기록 완료");
    }
}
