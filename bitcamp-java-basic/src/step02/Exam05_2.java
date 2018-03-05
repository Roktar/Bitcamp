package step02;

public class Exam05_2 { 
    public static void main(String[] args) {
        float f; 
        double d;

        // 이하 소수점은 4바이트 크기의 부동소수점 범위를 넘어가기때문에 변수에 값을 넣기 전에 리터럴의 값이 4바이트 크기로 잘림.
        f = 9876.98769876f;
        d = 9876.98769876f; // 4바이트크기로 잘리게 됨.

        System.out.println(f + ", " + d);

        f = 9876.98769876f;
        d = 9876.98769876;

        System.out.println(f + ", " + d);
    }
}