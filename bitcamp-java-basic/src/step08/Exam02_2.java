package step08;

import java.util.Scanner;

public class Exam02_2 {
    static class Math {
        
        public static int abs(int val) {
            return ( val < 0 ? (val * (-1)) : val);
        } // 절대값으로 바꿔주는 함수
        
    }
    
/*    class Math {
        
        public int abs(int val) {
            return ( val < 0 ? (val * (-1)) : val);
        } // 절대값으로 바꿔주는 함수
        
    }*/


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력 > ");
        int val = sc.nextInt();
        sc.nextLine();
        
        int res = Math.abs(val);
        //Math m = new Math();
        //int res = m.abs(val);
        
        System.out.println(res);

    }
}
