package step22.ex2;

import java.io.FileReader;

// Character Stream - 문자 단위로 읽기
public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("temp/test2.txt");
        
        // JVM에 설정된 문자코드표가 UTF-8인 경우,
        // 1~4바이트까지 문자에 따라 가변적으로 읽어들인다.
        // 영어문자는 1바이트를 읽어서 2바이트로,
        // 글문자는 3바이트를 읽어 2바이트 UTF-16값으로 바꿀 것이다.
        // 문자에 따라 읽는 바이트의 갯수는 달라진다.
        // 이것이 FileInputStream과 FileReader의 차이점.
        int ch = in.read();
                
        System.out.printf("%x\n ", ch);
    }
}
