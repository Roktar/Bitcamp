package step22.ex2;

import java.io.FileReader;

//Character Stream - 문자 단위로 읽기
public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("temp/test2.txt");
        
        char[] buf = new char[100];
        
        int ch = in.read(buf);
                
        System.out.printf("%d\n ", ch);
        
        for(int i=0; i<ch; i++)
            System.out.printf("%c(%x) ", buf[i], (int)buf[i]);
    }
}
