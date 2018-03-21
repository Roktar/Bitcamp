package step09;

import java.util.Date;

public class Exam01_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Date d1 = new Date(System.currentTimeMillis());
        System.out.println(d1);
        
        Date d2 = new Date(118, 3-1, 20); 
        // year는 기본값이 1900인듯.
        // month는 0부터 11의 범위를 갖는다.
        System.out.println(d2);
        
        // 밀리초를 ㄱ준으로 계산
        Date d3 = new Date(1000l * 60 * 60 * 24 * 365 * 50);
        System.out.println(d3);
        
        System.out.println(System.currentTimeMillis());
        System.out.println( 1000 * 60 * 60 * 24 * 365 * 50 );
    }

}
