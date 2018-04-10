package step21.ex3;

import java.util.Scanner;

public class Exam06_1 {
    static void m() {
        Scanner sc = new Scanner(System.in);
        // 스캐너 객체를 사용하여 키보드 입력을 받아들임
        System.out.print("입력> ");
        int val = sc.nextInt();
        System.out.println(val * val);
        
        // 자원해제
        // - 한 프로그램이 특정 자원(여기서는 입력자원 스캐너)을 사용하는데
        //   다른 프로그램에서 요구하는 경우, (단 여기서는 입력을 당분간 안한다고 가정)
        //   해당 자원을 다른 프로그램에서 사용할 수 있도록 자원을 해제하여 반환하는 것을 말함
        //   자원 해제 명령은 보통 close메소드.
        //   단, 작업이 빨리 끝나고 프로그램을 빠르게 종료하는 경우, 자원해제를 안해도 된다.
        //   어차피 프로그램이 끝나면 사용했던 모든 자원이 반환되기 때문이다.
        
        // - 하지만 우리는 24시간 실행되는 서버쪽 프로그램을 개발하게 될 것이기때문에
        //   항상 자원을 사용한 후 사용하지않는다면 자원을 해제해줘야한다.
        sc.close();
    }
    
    public static void main(String[] args) {
        m();
    }
}
