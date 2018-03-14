package step05.assignment;

import java.util.Scanner;

public class Test03_bitcamp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len;

        System.out.print("밑변 길이 ? ");
        len = sc.nextInt();

        int sLen = 1;

        while(sLen <= len) {
            int spCnt = 1;
            int spLen = (len-sLen) / 2;

            int sCnt = 1;

            while(spCnt++ <= spLen)
                System.out.println(" ");

            while(sCnt++ <= sLen)
                System.out.println("*");

            System.out.println();
            sLen += 2;
        }
    }
}