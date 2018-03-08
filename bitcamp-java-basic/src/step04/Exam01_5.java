package step04;

public class Exam01_5 {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float f = 5.5f;
        double d = 6.6;
        char c = 7;

        //byte b1 = b+b; // error
        //short s1 = s+s; // error
        int i1 = b+i;
        int i2 = s+i;
        //int i3 = i+l; // error
        //long l1 = l+f; // error
        //int i4 = i+f; // error
        //long l2 = b + s + i + l + f + d + c;

        boolean bool = true;
        //int i5 = bool + i; // error

        int x = Integer.MAX_VALUE; // 0x7FFFFFFF
        int y = Integer.MAX_VALUE; 
        int i5 = x+y; // 0xFFFFFFFE
        long l3 = x+y;
        System.out.println(i5);
        System.out.println(l3);
    }
}