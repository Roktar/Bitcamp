package step11.ex12;
// Object 클래스 메소드 override - toString()
public class Exam01_2 {
    
    static class Score {
        String name;
        int kor, eng, math, sum;
        float avg;
        
        public Score(String name, int kor, int eng, int math) {
            this.name= name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.sum = this.kor + this.eng + this.math;
            this.avg = this.sum / 3f;
        }        
        
        // 내부 값을 빠르게 확인하고싶을 떄 오버라이딩해서 많이 쓴다.
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return String.format("%s, %d, %d, %d, %d, %.1f", this.name, this.kor, this.eng, this.math, this.sum, this.avg);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Score s1 = new Score("홍길동", 100, 100, 100);
        System.out.println(s1.toString());
        
    }
}
