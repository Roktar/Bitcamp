package step06;

import java.util.Scanner;

public class Exam01_3 {
    //space를 출력하는 코드들을 관리 용이하게 별도의 블록에 모아놓는다.
    //그리고 그 블록에 이름을 붙인다.
    public static void printSpaces(int len) {
        for(int i = 0; i < len; i++)
            System.out.print(" ");
    }

    public static void printStars(int len) {
        for(int i=0; i < len; i++)
            System.out.print("*");
    }

    public static int getSpaceLength(int totalStar, int displayStar) {
        return ((totalStar - displayStar) /2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len;

        System.out.print("밑변 길이 ? ");
        len = sc.nextInt();
        // sLen : *이 출력될 갯수, 처음엔 1개 출력하고 뒤로갈수록 2개씩 늘린다.
        for(int sLen = 1; sLen <= len; sLen += 2) {
            printSpaces( getSpaceLength(len, sLen) );
            printStars(sLen);
            
            System.out.println();
        }
    }
}