package step02;

public class Exam08_2 { 
    public static void main(String[] args) {
        byte b = 100;
        short s = 100;
        int i = 100;
        long l = 100;
        char c = 100;

        byte b2;
        short s2;
        int i2;
        long l2;
        char c2; // 같은 2바이트여도 유효한 값의 범위가 다름.(char은 음수없이 65535까지.)

        // 작은 메모리의 값을 큰 메모리에 넣을 수 있음.
        i2 = s; // int(4) <= short(2)
        l2 = i; // long(8) <= int(4)
        s2 = b; // short(2) <= byte(1)
        i2 = c; // int(4) <= char(2)


    }
}