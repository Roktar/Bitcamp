package step23.ex4;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// echoServer 만들기, connection Pool
public class CalcServer {
    public static void main(String[] args) throws Exception {
        ServerSocket sv = new ServerSocket(8888);
        System.out.println("서버 실행");

        Socket socket = sv.accept();
        System.out.println("클라이언트와 연결됨");
        
        DataInputStream in = new DataInputStream(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        System.out.println("클라이언트로부터 데이터를 받기위해 기다리는중");
        while(true) {
            int a = in.readInt();
            String op = in.readUTF();
            int b = in.readInt();
            int res = 0;
            
            switch(op) {
                case "+" : res = a+b; break;
                case "-" : res = a-b; break;
                case "*" : res = a*b; break;
                case "/" : res = a/b; break;
            }
            
            if(op.equalsIgnoreCase("quit"))
                break;
            
            out.printf("%d %s %d = %d\n", a, op, b, res);
            System.out.println(res);
        }
        System.out.println("클라이언트와의 연결 종료");
        in.close();
        out.close();
        socket.close();
        //sv.close();
    }
}
