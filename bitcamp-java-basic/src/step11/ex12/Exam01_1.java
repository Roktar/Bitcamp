package step11.ex12;
// Object 클래스 메소드 override - toString()
public class Exam01_1 {
    
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
        // toString() 오버라이딩-
        // 기본값 반환 : 패키지이름+클래스명@인스턴스 식별자
        // 예시로는 step11.ex12.Exam01@12a74311등으로 나온다.
        
        
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
        
        System.out.println(s1.toString());
    }
}
