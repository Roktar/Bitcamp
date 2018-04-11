package step22.ex1;

import java.io.FileInputStream;

// Byte Stream - 바이트 단위로 읽기
public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test1.data");
        
        byte[] buf = new byte[100];
        int count = in.read(buf);
        // buf 배열에 값을 저장하고 처리한 바이트의 수를 처리한다.
        // 여기서는 7바이트를 처리했기때문에 (1바이트) * 7, 7이 나온다.
                
        for(int i=0; i<count; i++) {
            System.out.printf("%x, ",buf[i]);
        }

    }
}
