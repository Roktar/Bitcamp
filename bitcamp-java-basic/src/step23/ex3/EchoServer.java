package step23.ex3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// echoServer 만들기
public class EchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket sv = new ServerSocket(8888);
        System.out.println("서버 실행");
        Socket socket = sv.accept();
        System.out.println("클라이언트와 연결됨");
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        // 데이터를 읽고 출력할 때는 반드시 클라이언트와의 통신 규칙을 따라야한다.
        // 클라이언트가 먼저 데이터를 보내면 서버는 그 데이터를 읽어야한다.
        System.out.println("클라이언트로부터 데이터를 받기위해 기다리는중");
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
        sv.close();
        
    }
}
