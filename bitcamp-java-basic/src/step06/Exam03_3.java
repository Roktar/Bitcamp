package step06;

import java.util.Scanner;

public class Exam03_3 {

    static void swap(MyObject ref) {
        // int tmp = a;
        // a = b;
        // b = tmp;

        ref.a += ref.b;
        ref.b = ref.a-ref.b;
        ref.a = ref.a-ref.b;

        System.out.printf("(in swap)a = %d, b = %d\n", ref.a, ref.b);
    }

    public static void main(String[] args) {  
        MyObject ref = new MyObject();
        ref.a = 100;
        ref.b = 200;
        swap(ref);

        System.out.printf("a = %d, b = %d\n", ref.a, ref.b);
    }
}

class MyObject {
    int a, b;
}