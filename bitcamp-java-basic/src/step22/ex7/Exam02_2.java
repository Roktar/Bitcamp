package step22.ex7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
// BufferedInputStream과 BufferedOutputStream을 사용하여 시간측정
public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream filein = new FileInputStream("temp/jls8.pdf");
        BufferedInputStream in = new BufferedInputStream(filein);
        
        FileOutputStream fileout = new FileOutputStream("temp/jls8_4.pdf");
        BufferedOutputStream out = new BufferedOutputStream(fileout);
        
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
