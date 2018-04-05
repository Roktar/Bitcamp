package step16.ex2;

import java.net.URL;
// Windows의 로컬 파일 경로를 URL로 표현하는 방법
public class Exam05 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("file://c:/workspace/bitcamp-java-basic/src/Hello.java");
        // 슬래시가 2개인지 3개인지 헷갈리네.
        System.out.printf("프로토콜 : %s\n", url.getProtocol()); 
        System.out.printf("서버주소 : %s\n", url.getHost()); // server addr
        System.out.printf("포트넘버 : %d\n", url.getPort());
        System.out.printf("자원경로 : %s\n", url.getPath());
        System.out.printf("참조경로(내부위치) : %s\n", url.getRef());
        System.out.printf("쿼리스트링 : %s\n", url.getQuery());        
       
    }
}
