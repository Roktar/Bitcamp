package step08;

public class Exam04_1 {
    static class Score {        
        String name;
        int kor, eng, math, sum;
        float avg;
        
        Score() {
            name = "";
            kor = eng = math = sum = 0;
            avg = 0.0f;
            System.out.println("Score 생성자 호---출");
        }
        
        public void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.avg = this.sum / 3f;
        }
        
        
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Score s1 = new Score();


    }

}
