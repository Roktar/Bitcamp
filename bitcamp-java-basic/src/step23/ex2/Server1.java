package step23.ex2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws Exception {
        
        ServerSocket ss = new ServerSocket(8888);
        
        System.out.println("클라이언트 연결을 기다리는 중...");
        
        Socket soc = ss.accept();
        
        System.out.println("대기중인 클라이언트 중 한 클라이언트 연결 승인");

        
        
        soc.close();
        ss.close();
        
        System.out.println("서버 닫음");
        
    }
}
