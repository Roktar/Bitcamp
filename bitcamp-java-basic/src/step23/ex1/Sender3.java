package step23.ex1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
// 상대방에게 연결을 요청하기 - Client
// client + keyboard + 반복문
public class Sender3 {
    public static void main(String[] args) throws Exception {
        // 키보드 입력 준비
        Scanner keyScan = new Scanner(System.in);
        
        // 1
        Socket socket = new Socket("192.168.0.3", 8888);
        
        // 2        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        while(true ) {
            // 키보드 입력을 받고 서버로 전송
            System.out.print("입력> ");
            String input = keyScan.nextLine();

            // 3
            out.println(input);
            
            // 4, 서버가 보낸 데이터를 수신
            String str = in.nextLine();
            System.out.println(str);
            
            // 대화를 종료하려면 quit을 입력.
            if(input.equalsIgnoreCase("quit"))
                break;
        }
        // 5
        in.close();
        out.close();
        
        // 6 
        socket.close();
        
        keyScan.close();
    }
}
