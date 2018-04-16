package step23.ex2;

import java.net.Socket;

// 클라이언트 생성
public class Client1 {
    public static void main(String[] args) throws Exception {
        System.out.println("연결 요청중..");
        
        Socket soc = new Socket("localhost", 8888);
        
        System.out.println("서버에 연결됨");
        
        
        soc.close();
        
    }
}
