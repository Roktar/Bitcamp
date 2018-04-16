package step23.ex2;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("서버 실행");
        
/*        sc.nextLine();
        System.out.println("서버 대기중.");*/
        
        ServerSocket ss = new ServerSocket(8888);
        
        sc.nextLine();
        System.out.println("클라이언트 연결을 기다리는 중...");
        
        Socket soc = ss.accept();
        
        System.out.println("대기중인 클라이언트 중 한 클라이언트 연결 승인");

        PrintStream out = new PrintStream(soc.getOutputStream());
        Scanner in = new Scanner(soc.getInputStream());
        System.out.println("입출력스트림 준비");
        
        System.out.println("클라이언트 데이터 수신중");
        System.out.println("Message : " + in.nextLine());
        System.out.println("클라이언트 데이터 수신 완료");
        
        System.out.println("- 클라이언트에게 응답을 보내기");
        out.println("OK");
        
        out.close();
        in.close();
        
        sc.nextLine();
        soc.close();
        ss.close();
    }
}
