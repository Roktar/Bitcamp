package step01;
public class Exam06_2 {
    public static void main(String[] args) {
        //exponential expression = 숫자e지수 또는 숫자E지수
        System.out.println(3.14);  // 8 byte 부동소수점
        System.out.println(3.14f); // 4 byte 부동소수점, f는 주로 소문자.

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        //4byte
        System.out.println(" ---- 4byte Size");
        System.out.println(987.6543f);
        System.out.println(987654.3f);
        System.out.println(9.876543f);
        //표시범위가 4바이트 메모리 범위를 넘어가기때문에 값이 잘린다.
        System.out.println(987654.345678f);
        System.out.println(98765434567.8f);
        System.out.println(9.87654345678f);

        //8byte
        System.out.println(" ---- 8byte Size");
        System.out.println(987.6543);
        System.out.println(987654.3);
        System.out.println(9.876543);
        // 8바이트 메모리 범위 안에서 표현가능한 부동소수점으로 정상출력된다.
        System.out.println(987654.345678);
        System.out.println(98765434567.8);
        System.out.println(9.87654345678);

        for(int i=0; i<20; i++)
            System.out.println("i * 0.1 : " + (i*0.1) + ", i :" + i + ", double i = " + (double)i + ", equals :" + ((double) i == (i*0.1)) );
    }
}