package step23.ex6;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//연결지향
//- 연결 후 데이터 송수신을 하는 것으로 송수신에 대한 신뢰를 보장.(연결로 인해)
//- TCP가 대표적인 예.

public class ConnectionOrientedServer {
    public static void main(String[] args) throws Exception {
        ServerSocket sv = new ServerSocket(8888);
        System.out.println("서버 실행");
        Socket socket = sv.accept();
        System.out.println("클라이언트와 연결됨");
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        System.out.println("클라이언트로부터 데이터를 받기위해 기다리는중");
        
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
        sv.close();
    }
}
