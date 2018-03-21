package step08;

public class Exam04_2 {
    static class Score {        
        String name;
        int kor, eng, math, sum;
        float avg;
        
        Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            sum = 0;
            avg = 0.0f;
            this.compute();
            System.out.println("매개변수 있는 Score 생성자 호---출");
        }
        
        public void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.avg = this.sum / 3f;
        } 
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Score s1 = new Score("홍길동", 100, 90, 80);
        Score s2 = new Score("임꺽정", 100, 90, 80);
        Score s3 = new Score("유관순", 100, 90, 80);
        
        System.out.printf("%s %d %d %d %d %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.avg);
        System.out.printf("%s %d %d %d %d %.1f\n", s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.avg);
        System.out.printf("%s %d %d %d %d %.1f\n", s3.name, s3.kor, s3.eng, s3.math, s3.sum, s3.avg);
    }

}
