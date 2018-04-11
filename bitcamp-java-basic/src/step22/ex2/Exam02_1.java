package step22.ex2;

// Character Stream - 문자 단위 출력
import java.io.FileWriter;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileWriter out = new FileWriter("temp/test2.txt");
        
        // 문자는 유니코드값이 저장된다.
        char[] chars = new char[] { 'A', 'B', 'C', '가', '각', '간', '똘', '똠', '똡', '똣', '똥' };
        
        out.write(chars);
        // 자바는 UTF-16을 사용하므로 JVM 기본 문자코드표에 따라 변환하여 출력한다.
        // 만약 JVM이 입출력 문자 코드표로 UTF-8을 쓴다면?
        // 한글은 1바이트, 영어는 3바이트로 변환되어 출력된다.
        
        out.close();

        System.out.println("문자 출력 완료");
    }
}
