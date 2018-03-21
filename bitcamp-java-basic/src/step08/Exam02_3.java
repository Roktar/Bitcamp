package step08;

import java.util.Scanner;

public class Exam02_3 {
    
    static class Score {
        String name;
        int kor, eng, math, sum;
        float avg;
        
        public void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.avg = this.sum / 3f;
        }
    } // exam02_3 클래스에 포함되잇어서 이 클래스 객체가 만들어져야 인식되는 듯.

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("성적 데이터 입력 (예: 홍길동 100 100 100)> ");
        Score s1 = new Score();
        s1.name = sc.next();
        s1.kor = sc.nextInt();
        s1.eng = sc.nextInt();
        s1.math = sc.nextInt();
        s1.compute();
        
        System.out.println("성적 데이터 입력 (예: 홍길동 100 100 100)> ");
        Score s2 = new Score();
        s2.name = sc.next();
        s2.kor = sc.nextInt();
        s2.eng = sc.nextInt();
        s2.math = sc.nextInt();
        s2.compute();
        
        System.out.printf("%s %d %d %d %d %.1f", s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.avg);
        System.out.printf("%s %d %d %d %d %.1f", s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.avg);
        

    }
}
