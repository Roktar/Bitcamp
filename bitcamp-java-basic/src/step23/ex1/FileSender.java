package step23.ex1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
// 상대방에게 연결을 요청하기 - Client
// client + keyboard + 반복문
public class FileSender {
    public static void main(String[] args) throws Exception {
        // 키보드 입력 준비
        Scanner keyScan = new Scanner(System.in);
        
        // 1
        Socket socket = new Socket("localhost", 8888);
        
        // 2        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        while(true ) {
            // 키보드 입력을 받고 서버로 전송
            System.out.print("입력> ");
            String input = keyScan.nextLine();
            
            if(input.startsWith("file:")) {
                BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(input.split("file:")[1]));
                System.out.println(input.split("file:")[1]);
                
                out.println("file:");
                int b = 0;
                
                while( (b = fileIn.read() ) != -1) {
                    out.println(b);
                }
                
                out.println(0x000000ff);
                System.out.println("파일 전송완료!");
            } else 
                out.println(input); // 3
            
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
