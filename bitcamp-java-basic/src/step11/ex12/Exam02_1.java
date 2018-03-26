package step11.ex12;
// Object 클래스 메소드 override - toString()
public class Exam02_1 {
    
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
        
        // 인스턴스가 달라도 값이 같으면 같은 해시값을 반환하도록 오버라이딩
        
        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            // 가장 심플한 방법은 모든 값을 문자열로 만들어붙이고
            // String 클래스에 있는 hashcode 함수를 사용하는 것이다.
            // String 클래스에 있는 해시코드는 문자열이 같은 경우
            // 같은 해시값을 리턴하도록 오버라이딩되어있다.
            
            String val = String.format("%s, %d, %d, %d, %d, %.1f", this.name, this.kor, this.eng, this.math, this.sum, this.avg);

            return val.hashCode();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Score s1 = new Score("홍길동", 100, 100, 100);
        Score s2 = new Score("홍길동", 100, 100, 100);
        
        System.out.printf("%d %d\n", s1.hashCode(), s2.hashCode());
        // 기본적으로 인스턴스 각각의 고유 값을 리턴한다.
        // 인스턴스 주소값이 아님을 유의.
        
        System.out.println(s1.hashCode() == s2.hashCode());
        
        
        
    }

}
