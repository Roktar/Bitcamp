package step22.ex3;

import java.io.FileOutputStream;

// Byte Stream - 바이트 단위로 쓰기
public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        int money = 1_3456_7890;

        out.write(money);

        out.close();
        System.out.println("기록 완료");
    }
}
