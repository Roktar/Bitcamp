package step02;

public class Exam08_6 { 
    public static void main(String[] args) {
        byte b = 100;
        short s = 100;
        int i = 100;
        long l = 100;
        
        // 명시적 형변환
        byte b2 = (byte)s;
        System.out.println(b2);

        b2 = (byte)i;
        System.out.println(b2);

        //int i2 = 300;
        int i2 = 0b00000000_00000000_00000001_00101100; // 10진수로 300
        b2 = (byte) i2;
        System.out.println(b2); // 0b0010_1100


    }
}