package step05.assignment;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = 0;

        System.out.print("밑변 길이 ? ");
        size = sc.nextInt();

        int m = (size/2);
        int loop = 1, spCnt = m, sCnt = 0, sLen = 1;

        while( loop < (m+2) ) {
            while( spCnt-- != 0 )
                System.out.print(" ");

            while( sCnt++ < sLen)
                System.out.print("*");

            System.out.println();
            sCnt = 0;
            spCnt = m - loop;
            sLen += 2;
            loop++;
        }
    }
}