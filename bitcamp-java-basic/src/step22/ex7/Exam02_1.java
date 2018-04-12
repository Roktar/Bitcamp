package step22.ex7;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileInputStream filein = new FileInputStream("temp/jls8.pdf");
        BufferedInputStream in = new BufferedInputStream(filein);
        
        int b;
        
        long startTime = System.currentTimeMillis();
        
        int callCount = 0;
        while(( b = in.read() ) != -1 ) { 
            callCount++; 
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println( " readtime : " + (endTime - startTime) + "ms");
        
        in.close();
    }
}
