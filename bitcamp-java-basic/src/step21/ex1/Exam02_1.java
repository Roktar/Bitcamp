package step21.ex1;

import java.util.Scanner;

// 예외처리 적용 전
public class Exam02_1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.print("입력> ");
            String op = sc.next();
            
            if(op.equalsIgnoreCase("quit"))
                break;
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            
            int result = Calculator2.compute(op, v1, v2);
            
            // 일반적인 연산에서는 문제가 없음
            // 하지만 0으로 나누는 것처럼 계산 불가능한 예외상황이 발생하는 경우
            // JVM은 실행을 종료한다.
            if(result == -1212121212)
                System.out.println("유효하지않은 연산");
            else
                System.out.println(result);
        }
        sc.close();
    }
}
