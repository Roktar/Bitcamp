package step01;
public class Exam05_3 {

    public static void main(String[] args) {
        System.out.println(2147483647); // 4byte 양의 정수 최대값
        System.out.println(-2147483647); // 4byte 음의 정수 최대값. 이 값을 넘으면 컴파일에러난다.
        System.out.println(2147483648L); 
        System.out.println(-2147483649L);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }
}