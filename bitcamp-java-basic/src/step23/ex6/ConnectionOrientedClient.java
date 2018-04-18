package step23.ex6;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionOrientedClient {
    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("127.0.0.1", 8888);
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        // 데이터를 읽고 출력할 때는 반드시 클라이언트와의 통신 규칙을 따라야한다.
        // 클라이언트가 먼저 데이터를 보내는 경우, 데이터를 먼저 보내야한다.
        
        out.println(args[0]);
        System.out.println("서버로 데이터 송신");
        
        String str = in.nextLine();
        System.out.println("서버에서 데이터 수신");
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
        System.out.println("클라이언트 프로그램 종료");
    }
}
