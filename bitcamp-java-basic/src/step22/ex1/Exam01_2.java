package step22.ex1;

import java.io.FileInputStream;

// Byte Stream - 바이트 단위로 읽기
public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        // 1) 파일로 데이터를 읽을 객체 준비
        FileInputStream in = new FileInputStream("temp/test1.data");
        // windows에서 경로 구분자는 역슬래시로 쓸 시, 구분할 때마다 2개를 써야한다.
        // 단 슬래시로 쓸 경우는 하나만 있어도 된다.

        int b = in.read();
        System.out.printf("%x\n", b);
        try(FileInputStream in2 = new FileInputStream("temp/test1.data");) {
            int b2 = in2.read();
            System.out.printf("%x\n", b2);
        } catch (Exception e) {
            
        }
    }
}
