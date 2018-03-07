package step03;

public class Score {
    public String name;
    public int kor, eng, mat, sum;
    public float avg;

    public int Sum() {
        return this.kor + this.eng + this.mat;
    }
}