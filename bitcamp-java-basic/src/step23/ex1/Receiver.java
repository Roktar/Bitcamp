package step23.ex1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver {
    public static void main(String[] args) throws Exception {
        // 1
        ServerSocket svSocket = new ServerSocket(8888);
        
        // 2
        Socket socket = svSocket.accept();
        
        // 3        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // 4
        String str = in.nextLine();
        System.out.println("상대방 : " + str);
        
        // 5
        out.println("저는 이정호입니다. 반갑습니다.");
        
        // 6
        in.close();
        out.close();
        
        // 7
        socket.close();
        svSocket.close();
    }
}
