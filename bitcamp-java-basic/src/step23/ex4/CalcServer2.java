package step23.ex4;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// connectionless
public class CalcServer2 {
    public static void main(String[] args) throws Exception {
        ServerSocket sv = new ServerSocket(8888);
        System.out.println("서버 실행");

        while(true) {
            Socket socket = sv.accept();
            System.out.println("클라이언트와 연결됨");
            
            try {
                processRequest(socket);
            } catch(Exception e) {
                System.out.println("클라이언트 요청 처리 중 오류 발생\n다음 클라이언트의 요청 처리");
            }
        }
        
        //sv.close();
    }
    
    static void processRequest(Socket socket) throws Exception {
        System.out.println("클라이언트로부터 데이터를 받기위해 기다리는중");
        try(    
            Socket socket2 = socket; // socket의 주소를 넘겨줬기때문에 socket을 조작한다. => 대신 자원해제해준다.
            DataInputStream in = new DataInputStream(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            ) {
            l1 : while(true) {
                int a = in.readInt();
                String op = in.readUTF();
                int b = in.readInt();
                int res = 0;
                
                switch(op) {
                    case "+" : res = a+b; break;
                    case "-" : res = a-b; break;
                    case "*" : res = a*b; break;
                    case "/" : res = a/b; break;
                    case "quit" : break l1;
                }
                
                out.printf("%d %s %d = %d\n", a, op, b, res);
                System.out.println(res);
            }
        System.out.println("클라이언트와의 연결 종료");
        }
    }
}
