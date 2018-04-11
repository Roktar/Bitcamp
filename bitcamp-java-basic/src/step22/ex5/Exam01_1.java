package step22.ex5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        
        int b;
        
        long startTime = System.currentTimeMillis();
        
        while(( b = in.read() ) != -1 );
        
        long endTime = System.currentTimeMillis();
        
        System.out.println( " readtime : " + (endTime - startTime) + "ms");
        
        in.close();
    }
}
