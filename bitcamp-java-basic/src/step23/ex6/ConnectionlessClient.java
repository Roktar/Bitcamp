package step23.ex6;

import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// connectionless - 연결없이 데이터를 송신
// 

public class ConnectionlessClient {
    public static void main(String[] args) throws Exception {
        
        // 프로그ㅜ램 실행법
        // java -cp bin step23.ex6.connectionlessClient [ServerAddr] [msg]
        
        // connectionless 방식으로 통신을 수행할 소켓 생성
        DatagramSocket socket = new DatagramSocket();
        
        // 데이터를 받을 상대방의 주소
        String receiver = args[0]; // ip addr
        int port = 8888;
        // 보낼 데이터를 바이트배열로 준비
        byte[] bytes = args[1].getBytes("UTF-8");
        
        // 보낼 데이터를 패킷에 담기
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(receiver), port);
        
        // 데이터 전송
        socket.send(packet);
        System.out.println("데이터 전송 완료");
        
        socket.close();
        System.out.println("클라이언트 프로그램 종료");
    }
}
