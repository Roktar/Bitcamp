package step23.ex1;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiver {

    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트가 연결됨.");

        PrintStream out = new PrintStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        System.out.println("클라이언트로부터 데이터 수신 중...");

        //1) 파일 크기 읽기
        long filesize = in.readLong();
        
        //2) 파일 이름 읽기
        String filename = in.readUTF();
        
        //3) 파일 데이터 읽기
        File file = new File("temp/ok_" + filename);
        DataOutputStream fileOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        
        byte[] buf = new byte[8196];
        int b = 0;
        
        while( (b = in.read(buf)) != -1 ) {
            System.out.println(b);
            fileOut.write(buf);
        }
        
        System.out.println("클라이언트로부터 데이터 수신 완료!");
        
        //4) 클라이언트에게 응답하기
        out.println("OK!");
        
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
        fileOut.close();
    }
}
