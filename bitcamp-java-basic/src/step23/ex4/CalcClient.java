package step23.ex4;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// echoServer 만들기
public class CalcClient {
    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("localhost", 8888);
        
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        // 서버에서는 DataInputStream으로 받으니 여기서는 DataOutput으로.
        
        System.out.print("값1: ");
        out.writeInt( Integer.parseInt(sc.nextLine()));        
        System.out.print("연산자: ");
        out.writeUTF( sc.nextLine());        
        System.out.print("값2: ");
        out.writeInt( Integer.parseInt(sc.nextLine()));
        
        String str = in.nextLine();
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
        
    }
}
