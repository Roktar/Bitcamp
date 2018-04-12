package step22.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream("temp/jls8.pdf");
        
        int b;
        
        long startTime = System.currentTimeMillis();
        
        int callCount = 0;
        while(( b = in.read() ) != -1 ) { 
            callCount++; 
            System.out.printf("%x\n", b);
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println( " readtime : " + (endTime - startTime) + "ms");
        System.out.printf("%x", 0x000000ff & 0x000000ff);
        
        in.close();
    }
}
