package step22.ex6;

import java.io.ByteArrayInputStream;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        byte[] buf = { 0x41, 0x42, 
                      (byte) 0xea, (byte) 0xb0, (byte) 0x80, 
                      (byte) 0xea, (byte) 0xb0, (byte) 0x81, 
                      (byte) 0xea, (byte) 0xb0, (byte) 0x84, 
                      0x00, 0x00, 0x00, 0x1b, 0x01 };
        
        // 바이트 배열에서 데이터를 읽는 도구
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        
        // 보통 바이트 배열에서 데이터를 읽을 때 인덱스를 가지고 직접
        // 바이트 배열의 값을 읽는다.
        // 즉, 일반 배열처럼 값을 읽는 것이다.
        
        // 하지만 byte배열도 그냥 데이터 저장소로 간주하고 read함수를 사용해서
        // 읽을 수 있게 된다면,
        // 개발자는 파일이든 메모리든 read 함수 호출이라는 일관된 방법으로
        // 데이터를 읽을 수 있기때문에 유지보수를 편하게 할 수 있다.
        // => 데이터가 저장된 장소에 상관없이 데이터를 읽을 때는 read 메소드를 호출한다.
        //    라고하는 일관성있는 규칙이 생기게되는 것이다.
        
        int b;
        
        while(true) {
            b = in.read();
            if(b == -1)
                break;
            System.out.printf("%x ", b);
        }
        System.out.println();
        
        in.close();
    }
}
