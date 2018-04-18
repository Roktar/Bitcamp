package step23.ex7;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.etnews.com", 80);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        out.println("GET /20180416000399?mc=em_001_00001 HTTP/1.1");
        out.println("HOST: www.etnews.com");
        out.println("");
        
        while(true) {
            try {
                System.out.println(in.nextLine());
            } catch(Exception e) {
                break;
            }
        }
        
        out.close();
        in.close();
        socket.close();
    }
}
