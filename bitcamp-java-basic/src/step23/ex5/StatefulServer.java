package step23.ex5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StatefulServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        
        while(true) {
            Socket socket = ss.accept();
            processRequest(socket);
        }
    }
    
    static void processRequest(Socket socket) throws IOException {
        try (
              Socket socket2 = socket;
              PrintStream out = new PrintStream(socket.getOutputStream());
              Scanner in = new Scanner(socket.getInputStream())) {
            
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
