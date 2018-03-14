package step06;

import java.util.Scanner;

public class Exam02_4 {

    static String hello(String name, int age) {
        String retVal = String.format("%d살 %s님 반갑습니다.\n", age, name);

        return retVal;
    }

    public static void main(String[] args) {  
        String r = hello("홍길동", 20);
        System.out.println(r);

        //int r2 = hello(); // error
        
    }
}