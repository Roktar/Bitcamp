package step07.scores;

public class Score2 {
    public String name;
    public int kor, eng, math, sum;
    public float average;
    
//    void calculate() {
//        this.sum = this.kor + this.eng + this.math;
//        this.average =  (float)sum/3;
//    }
    
    public static void calculate(Score2 score) {
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum / 3f;
    }

//    void print() {
//        System.out.printf("이름\t  국어 \t  영어\t  수학\t  총점\t  평균\n");
//        System.out.printf("%s\t %3d\t %3d\t %3d\t %3d\t %.1f", this.name, this.kor, this.eng, this.math, this.sum, this.average);
//    }
} // 클래스 메소드를 사용했다.
