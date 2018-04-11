package step22.ex2;

import java.io.FileReader;

//Character Stream - 문자 단위로 읽기
public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("temp/test2.txt");
        
        char[] buf = new char[100];
        int count = in.read(buf, 10, 40);
        // 2번째 인자의 배열 인덱스부터 3번째 인자의 길이만큼 데이터를 입력받는다.
        // 읽는 것은 이전과 동일하다. ( 맨 앞부터 읽음 )
                
        for(int i=10; i<count+10; i++) {
            System.out.printf("%c(%x), ", buf[i], (int)buf[i]);
        }
    }
}
