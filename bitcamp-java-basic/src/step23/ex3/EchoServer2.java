package step23.ex3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 여러 클라이언트의 요청 처리
public class EchoServer2 {
    public static void main(String[] args) throws Exception {
        ServerSocket sv = new ServerSocket(8888);
        System.out.println("서버 실행");
        
        while ( true ) {
            Socket socket = sv.accept(); // 소켓과 연결
            System.out.println("클라이언트와 연결됨");
            
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            
            System.out.println("클라이언트로부터 데이터를 받기위해 기다리는중");
            String str = in.nextLine();
            out.println(str);
            System.out.println(str);
            
            in.close();
            out.close();
            socket.close();
        }
        
/*        in.close();
        out.close();
        socket.close();
        sv.close();*/
    }
}
