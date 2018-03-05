package step02;

public class Exam03_4 { 
    public static void main(String[] args) {
        // 1. 선언 후 값을 집어넣는 방법
        int a1, a2;
        a1 = a2 = 100;
        System.out.println(a1);
        System.out.println(a2);

        // 2. 선언과 동시에 값을 집어넣는 방법
        int b1= 200, b2 = 250;
        System.out.println(b1);
        System.out.println(b1);

        int c1 = 300, c2, c3 = 380, c4;
    

        System.out.println(c1);
        System.out.println(c2 = c1);
        System.out.println(c3);
        System.out.println(c4 = c3);
        
    }
}