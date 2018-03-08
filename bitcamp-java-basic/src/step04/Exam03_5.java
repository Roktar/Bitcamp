package step04;

public class Exam03_5 {
    public static void main(String[] args) {

        int a = 0b0110_1100;
        int b = 0b0101_0101;

        //System.out.println(a && b);
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(~a + ", " + ~b);
    }
}