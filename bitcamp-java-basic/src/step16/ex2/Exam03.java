package step16.ex2;

import java.net.URL;

public class Exam03 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.bitcamp.co.kr/a/b/hello.html#footer");
        // 태그를 지정할 수 있다. 셀렉터같은 느낌.
        System.out.printf("프로토콜 : %s\n", url.getProtocol()); 
        System.out.printf("서버주소 : %s\n", url.getHost()); // server addr
        System.out.printf("포트넘버 : %d\n", url.getPort());
        System.out.printf("자원경로 : %s\n", url.getPath());
        System.out.printf("참조경로(내부위치) : %s\n", url.getRef());
       
    }
}
