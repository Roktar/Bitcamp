package step23.ex5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 멀티 쓰레드 적용

public class StatefulServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("Server on");
        
        while (true) {
            Socket socket = ss.accept();

            System.out.println("클라이언트 연결 승인");
            // 클라이언트의 요청을 처리할 객체를 지정
            MyThread requestHandler = new MyThread(socket);
            // 객체를 통해 클라이언트의 요청을 처리한다.
            requestHandler.run();
        }
    }

    // 클라이언트의 요청을 처리할 객체 -> 독립적으로 수행
    static class MyThread extends Thread {
        Socket socket;

        public MyThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket socket2 = socket;
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner in = new Scanner(socket.getInputStream())) {

                int sum = 0;

                while (true) {
                    String str = in.nextLine();

                    if (str.equals(""))
                        break;

                    sum += Integer.parseInt(str);
                }
                out.println("결과 : " + sum);
            } catch (Exception e) {
                System.out.println("에러 발생");
            }
        }
    }
}
