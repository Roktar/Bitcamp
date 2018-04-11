package step22.ex1;

import java.io.FileOutputStream;

// Byte Stream - 바이트 단위로 쓰기
public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        // 1) 파일로 데이터를 출력하는 객체 준비
        FileOutputStream out = new FileOutputStream("temp/test1.data");
        // windows에서 경로 구분자는 역슬래시로 쓸 시, 구분할 때마다 2개를 써야한다.
        // 단 슬래시로 쓸 경우는 하나만 있어도 된다.
        
        // 2) 4바이트 출력
        out.write(0x7a6b5c4d); 
        
        // 3) 출력 도구 자원 해제
        // - 어떤 입출력 객체는 닫지않으면 버퍼에 남아있는 데이터가 그대로 사라진다.
        out.close();
        
        try(FileOutputStream out2 = new FileOutputStream("temp/test1.data");) {
            out2.write(0x7a6b5c4d);
        } catch (Exception e) {
            
        }
        System.out.println("데-이타 출력 완료");
    }
}
