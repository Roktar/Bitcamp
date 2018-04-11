package step22.ex2;

import java.io.FileWriter;

//Character Stream - 문자 단위 출력
public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        FileWriter out = new FileWriter("temp/test2.txt");
        
        char[] bytes = new char[] { 0x7a, 0x6b, 0x5c, 0x4d, 0x3e, 0x2f, 0x30 };

        out.write(bytes, 2, 3);
        // 2번 데이터부터 3바이트를 출력한다.
        out.close();
        
        System.out.println("데-이타 쓰기 완료");
    }
}
