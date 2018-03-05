package step02;

public class Exam05_1 { 
    public static void main(String[] args) {
        float f; // 유효 자릿수 7자리 정도

        f = 9.876545f;
        System.out.println(f);

        f = 987654.5f;
        System.out.println(f);

        f = 0.000009876545f;
        System.out.println(f);

        f = 9876545000000L;
        System.out.println(f);

        f = 987654500;
        System.out.println(f);
    }
}