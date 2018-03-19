package step07.scores;

public class Score3 {
    public String name;
    public int kor, eng, math, sum;
    public float average;
    
    public void calculate() {
        this.sum = this.kor + this.eng + this.math;
        this.average = this.sum / 3f;
    }

    public void print() {
        System.out.printf("이름\t  국어 \t  영어\t  수학\t  총점\t  평균\n");
        System.out.printf("%s\t %3d\t %3d\t %3d\t %3d\t %.1f", this.name, this.kor, this.eng, this.math, this.sum, this.average);
    }
}
// 인스턴스의 주소는 내장된 this라는 변수에 자동 복사되기에 파라미터대신 this를 사용하면 된다.
