package step22.ex3;

import java.io.FileInputStream;

public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        // read할 때는 원형 그대로 가져나오지만 저장할 때는 마지막 1비트만 
        // 저장되는 듯.
        
        long value = (long)in.read() << 56;
        //System.out.printf("%x\n", value);
        value += (long)in.read() << 48;
        //System.out.printf("%x\n", value);
        value += (long)in.read() << 40;
        //System.out.printf("%x\n", value);
        value += (long)in.read() << 32;
        //System.out.printf("%x\n", value);
        value += (long)in.read() << 24;
        //System.out.printf("%x\n", value);
        value += (long)in.read() << 16;
        //System.out.printf("%x\n", value);
        value += (long)in.read() << 8;
        //System.out.printf("%x\n", value);
        value += (long)in.read();
        
        System.out.printf("%x\n", value);
        System.out.println(value);
        
        in.close();
        
    }
}
