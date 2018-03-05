package step02;

public class Exam04_2 { 
    public static void main(String[] args) {
        int i = 50;
        byte b = 100;
        b = (byte) i;

        short s = 100;
        s = (short) i;

        int j = 100;
        j = i;

        long l = 100;
        l = i;

        int k = 100;
        k = (int)l;
        System.out.println(b);
    }
}