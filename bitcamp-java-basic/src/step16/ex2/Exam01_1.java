package step16.ex2;

import java.net.URL;

// URL을 다루는 클래스
public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        URL url = new URL("http://www.bitcamp.co.kr:8080/a/b/hello.html");
        
        System.out.printf("프로토콜 : %s\n", url.getProtocol()); 
        System.out.printf("서버주소 : %s\n", url.getHost()); // server addr
        System.out.printf("포트넘버 : %d\n", url.getPort());
        System.out.printf("자원경로 : %s\n", url.getPath());

    }

}
