package step23.ex4;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 접속 유지(Connection Pool)
public class CalcClient3 {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        Socket socket = new Socket("localhost", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        // 서버에서는 DataInputStream으로 받으니 여기서는 DataOutput으로.
        
        while(true) {
            System.out.print("값1: ");
            int a = Integer.parseInt(sc.nextLine());        
            System.out.print("연산자: ");
            String op = sc.nextLine();        
            System.out.print("값2: ");
            int b = Integer.parseInt(sc.nextLine());
            
            out.writeInt(a); 
            out.writeUTF(op); 
            out.writeInt(b); 
            // 데이터를 미리 받아둔 후 서버 연결함과 동시에 데이터 전송
            
            String str = in.nextLine();
            System.out.println(str);
            
            if(str.equals("quit"))
                break;
        }
        
        in.close();
        out.close();
        socket.close();
    }
}
