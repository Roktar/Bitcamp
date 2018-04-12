package step22.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
// BufferedInputStream과 BufferedOutputStream을 사용하여 시간측정
public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream("temp/jls8.pdf");
        BufferedOutputStream out = new BufferedOutputStream("temp/jls8_4.pdf");   
        
        int b;
        
        long startTime = System.currentTimeMillis();
        
        while(( b = in.read() ) != -1 )
            out.write(b);
        
        long endTime = System.currentTimeMillis();
        
        System.out.println( " readtime : " + (endTime - startTime) + "ms");
        
        in.close();
        out.close();
    }
}
