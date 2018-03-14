package step06;

import java.util.Scanner;

public class Exam04_5 {

    static int sum(int val) {
        if(val==1)
            return 1;
        System.out.println(val);
        return val + sum(val-1);
    }
    
    public static void main(String[] args) {  
        int r = sum(100);
        System.out.println(r);

        // int r2 = sum(100000); // 오버플로 걸리기가 쉽다.

        Runtime run = Runtime.getRuntime();
        System.out.println(run.totalMemory()+" byte");
        System.out.println(run.freeMemory() + " byte");
        System.out.println((run.totalMemory() - run.freeMemory())  + " byte");
    }
}