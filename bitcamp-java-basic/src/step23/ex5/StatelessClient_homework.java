// Stateless와 Stateful 의 비교 
package step23.ex5;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// stateless 방식의 특징
// => 요청 할 때마다 서버와 연결한다. 응답 받은 후 서버와의 연결을 끊는다. 
// 
public class StatelessClient_homework {
    public static void main(String[] args) throws Exception {
        
        try (Scanner keyScan = new Scanner(System.in)) {
            System.out.print("값? ");
            String str = keyScan.nextLine(); // 키보드에서 값을 입력 받아
                
            try (
                Socket socket = new Socket("localhost", 8888);
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream())) {
                
                out.println(args[0]);
                out.println(str);
                
                if (str.equals("")) // 만약 값을 입력하지 않았으면 
                    System.out.println(in.nextLine()); // 서버가 보낸 결과를 출력한다.
            }
        }
    }
}