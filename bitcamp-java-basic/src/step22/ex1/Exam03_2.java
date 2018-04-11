package step22.ex1;

import java.io.FileInputStream;

// Byte Stream - 바이트 단위로 읽기
public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test1.data");
        
        byte[] buf = new byte[100];
        int count = in.read(buf, 10, 4);
        // 2번째 인자의 배열 인덱스부터 3번째 인자의 길이만큼 데이터를 입력받는다.
        // 즉, buf[10] 부터 buf[13]까지 데이터를 넣는다.
        // 읽는 것은 이전과 동일하다. ( 맨 앞부터 읽음 )
                
        for(int i=10; i<count+10; i++) {
            System.out.printf("%x, ",buf[i]);
        }
    }
}
