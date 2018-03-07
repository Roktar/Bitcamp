package step04;

public class Exam01_3 {
    public static void main(String[] args) {
        byte b = 5 + 6;
        
        byte b1 = 5, b2 = 6, b3;
        b3 = (byte)(b1 + b2);

        short s1 = 3, s2 = 8, s3;
        s3 = (short)(s1 + s2);

        int i1;
        i1 = b3+s3;

        System.out.println(b3);
    }
}