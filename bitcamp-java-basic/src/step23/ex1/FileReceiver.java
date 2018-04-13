package step23.ex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
// 상대편으로부터 연결 요청 받기
// 반복문
public class FileReceiver {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        // 1
        ServerSocket svSocket = new ServerSocket(8888);
        
        // 2, 연결 승낙
        Socket socket = svSocket.accept();
        
        // 3        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        while(true) {
            // 4, Client가 보낸 문자열을 수신.
            String str = in.nextLine();
            
            if(str.startsWith("file:")) {
                System.out.println("상대방이 파일을 보냈습니다.");
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("temp/selfData.txt")); // 저장 위치 지정
                
                System.out.println(in.nextInt());
                bos.write(in.nextInt());
                
                System.out.println("파일 송신완료");
            } else            
                System.out.println("상대방 : " + str);
            
            // 5, 키보드 입력값을 전송한다.
            System.out.print("입력> ");
            String input = keyScan.nextLine();
                            
            out.println(input);
            
            if(str.equalsIgnoreCase("quit"))
                break;
        }
        // 6
        in.close();
        out.close();
        
        // 7
        socket.close();
        svSocket.close();
        
        keyScan.close();
    }
}
