package step23.ex6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//연결지향
//- 연결 후 데이터 송수신을 하는 것으로 송수신에 대한 신뢰를 보장.(연결로 인해)
//- TCP가 대표적인 예.

public class ConnectionlessServer {
    public static void main(String[] args) throws Exception {
        // 특정 포트로 들어온 데이터를 받을 서버소켓 준비
        DatagramSocket socket = new DatagramSocket(8888);
        
        // 클라이언트가 수신한 바이트 데이터를 저장할 버퍼 준비
        byte[] buf = new byte[8196];
        
        // 빈 패킷을 준비
        DatagramPacket emptryPacket = new DatagramPacket(buf, buf.length);
        
        // 빈 패킷에 데이터를 받아온다.
        socket.receive(emptryPacket);
        
        socket.close();
        
        // 빈 패킷에 저장된 수신데이터를 꺼낸다.
        // emptyPacket.getData()로 데이터를 꺼내고 그 배열의 0번부터 끝까지 UTF-8형식의 데이터로 채운다.
        String msg = new String(emptryPacket.getData(), 0, emptryPacket.getLength(), "UTF-8");
        System.out.println(msg);
        
    }
}
