package step21.ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

// 예외처리 적용 전
public class Exam02_2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.print("입력> ");
            String op = sc.next();
            
            if(op.equalsIgnoreCase("quit"))
                break;
            
            try {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                
                int result = Calculator3.compute(op, v1, v2);
                
                if(result == -1212121212)
                    System.out.println("유효하지않은 연산");
                else
                    System.out.println(result);
            } catch(InputMismatchException e) {
                System.out.println("입력값이 유효하지않습니다.");
                sc.nextLine();
            } catch(RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
