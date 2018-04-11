package step22.ex1;

import java.io.FileOutputStream;

// Byte Stream - 바이트 배열로 쓰기
public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test1.data");
        
        byte[] bytes = new byte[] { 0x7a, 0x6b, 0x5c, 0x4d, 0x3e, 0x2f, 0x30 };

        // 바이트 배열을 받는 함수를 호출
        out.write(bytes); 
        
        out.close();
        
        System.out.println("데-이타 쓰기 완료");
    }
}
