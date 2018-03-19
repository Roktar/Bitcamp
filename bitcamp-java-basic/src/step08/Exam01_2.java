package step08;

public class Exam01_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // 1 - 성적 데이터를 설계할 클래스이기에 특징에 맞는 클래스명을 사용하라.
        class Score {
            // 2 - 여러 명의 성적 데이터를 저장하기에 인스턴스 변수로 메모리 설계.
            
            String name;
            int kor, eng, math, sum;
            float avg;
        }

        Score s1 = new Score(); // 1명분의 성적 데이터를 저장할 메모리 생성
        Score s2 = new Score();
        Score s3 = new Score();
        
        // 각 인스턴스에 한 명 분의 성적 데이터를 저장한다.
        
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 90;
        s1.math = 80;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.avg = (float)s1.sum / 3;
        // 한 명 분의 데이터를 입력
        
        s2.name = "임꺽정";
        s2.kor = 100;
        s2.eng = 100;
        s2.math = 100;
        s2.sum = s2.kor + s2.eng + s2.math;
        s2.avg = (float)s2.sum / 3;
        // 한 명 분의 데이터를 입력
        
        s3.name = "유관순";
        s3.kor = 100;
        s3.eng = 90;
        s3.math = 60;
        s3.sum = s3.kor + s3.eng + s3.math;
        s3.avg = (float)s3.sum / 3;
        // 한 명 분의 데이터를 입력
        
        System.out.println();
        
    }
}
