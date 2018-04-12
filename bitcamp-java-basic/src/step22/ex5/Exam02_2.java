package step22.ex5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_3.pdf");
        
        byte[] buf = new byte[8196]; // 보통 8k정도의 메모리를 준비한다.
                                        // 하지만 파일 크기가 약 400만 바이트정도라서 400만으로 설정.
        int len = buf.length;
        
        long startTime = System.currentTimeMillis();
        
        while(in.read(buf, 0, len) != -1)
            out.write(buf);

        long endTime = System.currentTimeMillis();
        
        System.out.println( " readtime : " + (endTime - startTime) + "ms");
        
        in.close();
    }
}
