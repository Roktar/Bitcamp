package step04;

public class Exam04_3 {
    public static void main(String[] args) {

        int i = 0b01101001;
        System.out.println(i >> 1);
        System.out.println(i >> 2);
        System.out.println(i >> 3);
        System.out.println(i >> 4);

        i = 0b11111111_11111111_11111111_10101001;
        System.out.println(i >>> 1);
        System.out.println(i >>> 2);
        System.out.println(i >>> 3);
        System.out.println(i >>> 4);
    }
}