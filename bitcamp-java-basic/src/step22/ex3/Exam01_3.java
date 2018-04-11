package step22.ex3;

import java.io.FileInputStream;

public class Exam01_3 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        // 4바이트를 읽어 4바이트 변수 int에 저장
        // => 읽은 바이트를 비트이동 연산자를 값을 이동 후 변수에 저장해야함.
        
        int value = (in.read() << 24);
        value += (in.read() << 16);
        value += (in.read() << 8);
        value += (in.read());
        
       
        System.out.printf("%x\n", value);
        
        in.close();
        
    }
}
