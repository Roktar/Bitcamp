package step02;

public class Exam08_3 { 
    public static void main(String[] args) {
        byte b = 100;
        short s = 100;
        int i = 98765678;
        long l = 98765678;
        char c = 100;

        float f;
        double d;

        f = b; // float(4) <= byte(1), 값을 거의 그대로 저장
        System.out.println(f);
        f = s; // float(4) <= short(2), 값을 거의 그대로 저장
        System.out.println(f);
        f = c; // float(4) <= char(2), 값을 거의 그대로 저장
        System.out.println(f);
        f = i; // float(4) <= int(4), 가수부 크기(23bit)를 넘는 정수는 잘림
               // 유효자릿수를 넘는 정수는 잘림
        System.out.println(f);
        f = l; // float(4) <= long(8), 가수부 크기(23bit)를 넘는 정수는 잘림
               // 유효자릿수를 넘는 정수는 잘림
        System.out.println(f);

        d = i; // double(8) <= int(4)
               // double의 가수부는 53비트 크기를 가지므로 int(32비트) 값을 그대로 저장할 수 있다.
               System.out.println(d);
        l = 18_2345_3456_4567_5678L;
        d = l; // double(8) <= long(8)
               // 53비트 가수부를 넘어간다면 값이 잘린다. 
               // 주의할 것은 컴파일 오류가 발생하지 않는다.
        System.out.println(d);
    }
}