package step23.ex5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StatefulClient {
    public static void main(String[] args) throws IOException {
        
        try (        
                Socket socket = new Socket("127.0.0.1", 8888);
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
                Scanner in = new Scanner(socket.getInputStream())
                //마지막 요소는 ;가 없어도 된다.
            ) {
        
            while(true) {
                System.out.print("값? ");
                String str = sc.nextLine(); // 값을 입력받음                
                out.println(str); // 서버로 값을 보냄
                
                if(str.equalsIgnoreCase("")) {
                    System.out.println(in.nextLine());
                    break;
                }
            } 
        }
    }
    
    static void processRequest(Socket socket) throws IOException {
        try (
              Socket socket2 = socket;
              PrintStream out = new PrintStream(socket.getOutputStream());
              Scanner in = new Scanner(socket.getInputStream());
            ) {
            
            int sum = 0;
            
            while(true) {
                String str = in.nextLine();
                
                if(str.equals(""))
                    break;
                
                sum += Integer.parseInt(str);
            }
            out.println("결과 : " + sum);
        }
    }
}
