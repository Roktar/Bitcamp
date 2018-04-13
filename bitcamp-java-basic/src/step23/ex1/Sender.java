package step23.ex1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws Exception {
        // 1
        Socket socket = new Socket("192.168.0.3", 8888);
        
        // 2        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // 3
        out.println("이정호입니다. 안녕하세요");
        
        // 4
        String str = in.nextLine();
        System.out.println(str);
        
        // 5
        in.close();
        out.close();
        
        // 6 
        socket.close();
    }
}
