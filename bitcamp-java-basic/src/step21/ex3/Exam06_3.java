package step21.ex3;

import java.io.FileReader;
import java.util.Scanner;
// auto-closable
public class Exam06_3 {
    static void m() throws Exception {
        
        try ( 
                Scanner sc = new Scanner(System.in); 
                FileReader in = new FileReader("Hello.java");
                //String s = "Hello"; // String은 auto-closable이 시행되지 않는다.
                //if(true ) {} // 여기에는 변수 선언부만 올 수 있다.
                //AutoClosable 구현체만 여기서 선언할 수 있다.
            ) {
            System.out.print("입력> ");
            int val = sc.nextInt();
            System.out.println(val * val);
        } // autoClosable을 사용하였기에 finally에서 자원해제를 해줄 필요성이 없다.
    }
    
    public static void main(String[] args) {
        m();
    }
}
