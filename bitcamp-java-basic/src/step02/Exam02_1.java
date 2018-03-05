package step02;

import java.util.Scanner;

import java.io.InputStream;

public class Exam02_1 { 
    public static void main(String[] args) {
        // 키보드 정보를 가져오는 것
        InputStream kbd = System.in;
        // 키보드에서 값을 꺼내주는 도구를 연결
        Scanner sc = new Scanner(kbd);
            
        System.out.print("팀명 : ");
        System.out.println("팀이름 : " + sc.nextLine());
    }
}