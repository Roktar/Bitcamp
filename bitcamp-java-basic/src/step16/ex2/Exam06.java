package step16.ex2;

import java.net.URL;
// Unix의 로컬 파일 경로를 URL로 표현하는 방법
public class Exam06 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("file:///home/hongkildong/test.txt");
        // 쿼리를 붙여서 보낼 수 있다.
        System.out.printf("프로토콜 : %s\n", url.getProtocol()); 
        System.out.printf("서버주소 : %s\n", url.getHost()); // server addr
        System.out.printf("포트넘버 : %d\n", url.getPort());
        System.out.printf("자원경로 : %s\n", url.getPath());
        System.out.printf("참조경로(내부위치) : %s\n", url.getRef());
        System.out.printf("쿼리스트링 : %s\n", url.getQuery());        
       
    }
}
