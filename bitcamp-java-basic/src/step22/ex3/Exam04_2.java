package step22.ex3;

import java.io.FileInputStream;

public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");

        byte[] buf = new byte[100];
        
        int count = in.read(buf);
        
        // 바이트 배열에 들어있는 값을 사용하여 String 인스턴스를 만든다.
        // new String(buf, 0, 10, "UTF-8");
        // - buf배열에서 0번 부터 10번 까지의 바이트 데이터를 꺼낸다.
        // - 그 바이트코드는 UTF-8로 되어있다.
        // - UTF-8 코드 배열을 UTF-16 문자 배열로 만들어 String 객체를 리턴
        String str = new String(buf, 0, count);
        // 단, 기록했을 때의 문자열 인코딩과 동일해야한다.
        
        System.out.printf("%s", str);
        
        in.close();
        
    }
}
