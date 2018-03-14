package step06;

import java.util.Scanner;
//Instance

public class Exam04_4 {

    static int m1(int val) {
        int r1 = m2(val);
        int r2 = m3(val);

        return r1 + r2;
    }

    static int m2(int val) {
        return val+100;
    }

    static int m3(int val) {
        return val+200;
    }

    public static void main(String[] args) {  
        int r = m1(5);
        System.out.println(r);
    }
}