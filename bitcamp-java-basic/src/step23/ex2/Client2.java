package step23.ex2;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// 클라이언트 생성
public class Client2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("연결 요청중..");
        
        sc.nextLine();
        Socket soc = new Socket("localhost", 8888);
        
        System.out.println("서버에 연결됨");
        // 서버와 바로 연결되는 것이 아니라 서버가 접속을 수락해야한다.
        // 단, 접속 순서대로 대기열에 들어가게 된다. 
        // 즉, 먼저 대기열에 들어간 클라이언트가 accept를 통해 먼저 연결되는 것이다.
        sc.nextLine();
        
        PrintStream out = new PrintStream(soc.getOutputStream());
        Scanner in = new Scanner(soc.getInputStream());
        
        System.out.println("입출력 스트림 준비");
        
        System.out.println("서버에 데이터 전송중");
        out.println(args[0]);
        System.out.println("서버에 데이터 전송 완료");
        
        System.out.println("- 서버로부터 응답을 받는 중");
        System.out.println("서버 응답 : " + in.nextLine());
        System.out.println("- 응답 확인 완료");
        
        out.close();
        in.close();
        
        soc.close();
    }
}
