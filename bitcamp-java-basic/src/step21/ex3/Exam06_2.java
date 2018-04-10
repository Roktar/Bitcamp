package step21.ex3;

import java.util.Scanner;

public class Exam06_2 {
    static void m() {
        Scanner sc = new Scanner(System.in);
        // 스캐너 객체를 사용하여 키보드 입력을 받아들임
        try {
            System.out.print("입력> ");
            int val = sc.nextInt();
            System.out.println(val * val);

        } finally {
            sc.close();
            System.out.println("스캐너 자원 해제");
        }
    }
    
    public static void main(String[] args) {
        m();
    }
}
