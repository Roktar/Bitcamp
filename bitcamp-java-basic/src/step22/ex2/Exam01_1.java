package step22.ex2;

// Character Stream - 문자 단위 출력
import java.io.FileWriter;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        FileWriter out = new FileWriter("temp/test2.txt");
        
        
        // 자바는 문자 데이터를 다룰 때, UTF-16(2byte)를 사용한다.(유니코드)
        // 그래서 출력 시, UTF-16 값을 JVM에 설정된 기본 문자코드표의 값으로 변환하여 출력
        // JVM 실행 시 출력 데이터의 문자 코드표를 미지정 시 OS의 기본 문자코드표에 따라 변환한다.
        // >java -Dfile.encoding=[문자코드표] -cp [클래스파일경로] [클래스명]
        
        // 따라서 다음 4바이트 값을 출력할 경우, 앞의 2바이트는 버린다.
        // 뒤의 2바이트를 UTF-8 코드표에 따라 1~4바이트 값으로 변환하여 출력한다.
        // 한글은 3바이트, 서유럽.중국 등은 4바이트
        out.write(0x7a6bAC00);
        out.close();

        System.out.println("문자 출력 완료");
    }
}
