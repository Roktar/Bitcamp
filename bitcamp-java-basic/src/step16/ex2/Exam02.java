package step16.ex2;

import java.net.URL;

public class Exam02 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.bitcamp.co.kr/a/b/hello.html");
        
        System.out.printf("프로토콜 : %s\n", url.getProtocol()); 
        System.out.printf("서버주소 : %s\n", url.getHost()); // server addr
        System.out.printf("포트넘버 : %d\n", url.getPort());
        System.out.printf("자원경로 : %s\n", url.getPath());
        // 포트번호를 뺐더니 -1이 나온다.
        

    }
}
