package step06;

import java.util.Scanner;
//Primitive

public class Exam04_1 {

    static void swap(int a, int b) {
        // int tmp = a;
        // a = b;
        // b = tmp;

        a += b; 
        b = a-b;
        a = a-b;

        System.out.printf("(in swap)a = %d, b = %d\n", a, b);
    }

    public static void main(String[] args) {  
        int a = 100, b = 200;
        swap(a, b);

        System.out.printf("a = %d, b = %d\n", a, b);
    }
}