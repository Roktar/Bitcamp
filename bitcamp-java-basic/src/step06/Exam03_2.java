package step06;

import java.util.Scanner;

public class Exam03_2 {

    static void swap(int[] arr) {
        // int tmp = a;
        // a = b;
        // b = tmp;

        System.out.printf("(in swap - before)a = %d, b = %d\n", arr[0], arr[1]);

        arr[0] += arr[1];
        arr[1] = arr[0] - arr[1];
        arr[0] -= arr[1];

        System.out.printf("(in swap - after)a = %d, b = %d\n", arr[0], arr[1]);
    }

    public static void main(String[] args) {  
        int[] arr = new int[] {100, 200};

        System.out.printf("(before swap)a = %d, b = %d\n", arr[0], arr[1]);
        swap(arr);
        System.out.printf("(in Main)a = %d, b = %d\n", arr[0], arr[1]);
    }
}