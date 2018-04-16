package step23.ex3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// echoServer 만들기
public class EchoClient {
    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("127.0.0.1", 8888);
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        // 데이터를 읽고 출력할 때는 반드시 클라이언트와의 통신 규칙을 따라야한다.
        // 클라이언트가 먼저 데이터를 보내는 경우, 데이터를 먼저 보내야한다.
        
        out.println(args[0]);
        
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
        
    }
}
