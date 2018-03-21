package step09;
// Math class

import java.lang.Math;

public class Exam02_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println(Math.E);
        
        System.out.println(Math.abs(-200)); // 절대값
        
        // 파라미터로 주어진 부동소수점의 큰 정수 값을 리턴
        System.out.println(Math.ceil(3.28));
        // 파라미터로 주어진 부동소수점의 바로 밑 작은 정수값을 리턴
        System.out.println(Math.floor(3.28)); 
        System.out.println(Math.ceil(-3.28)); 
        System.out.println(Math.floor(-3.28)); 
        
        // 거듭제곱
        System.out.println( (int)Math.pow(2, 7) );
        
        // 반올림
        System.out.println( Math.round(3.14));
        System.out.println( Math.round(3.54));
        
        
        
    }
}
