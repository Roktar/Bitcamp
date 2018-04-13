package step23.ex1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
// 상대편으로부터 연결 요청 받기
public class Receiver2 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        // 1
        ServerSocket svSocket = new ServerSocket(8888);
        
        // 2, 연결 승낙
        Socket socket = svSocket.accept();
        
        // 3        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // 4, Client가 보낸 문자열을 수신.
        String str = in.nextLine();
        System.out.println("상대방 : " + str);
        
        // 5, 키보드 입력값을 전송한다.
        System.out.print("입력> ");
        String input = keyScan.nextLine();
        out.println(input);
        
        // 6
        in.close();
        out.close();
        
        // 7
        socket.close();
        svSocket.close();
        
        keyScan.close();
    }
}
