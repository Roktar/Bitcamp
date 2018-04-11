package step22.ex5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        
        byte[] buf = new byte[8196]; // 보통 8k정도의 메모리를 준비한다.
        
        int b;
        
        long startTime = System.currentTimeMillis();
        
        while(( b = in.read(buf) ) != -1 );
        
        long endTime = System.currentTimeMillis();
        
        System.out.println( " readtime : " + (endTime - startTime) + "ms");
        
        in.close();
    }
}
