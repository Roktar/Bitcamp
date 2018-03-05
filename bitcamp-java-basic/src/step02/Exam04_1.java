package step02;

public class Exam04_1 { 
    public static void main(String[] args) {
        byte b1 = -128;
        byte b2 = 127;
        short s1 = -32768;
        short s2 = 32767;
        int i1 = -2147483648;
        int i2 = 2147483647;
        long l1 = -9223372036854775808L; // L빼면 에러임(L빼면 4바이트취급, 붙여야 8바이트취급)
        long l2 = 9223372036854775807L;

        short s3 = (short) 3*5; // OK
        byte b = 100L; // ERROR
    }
}