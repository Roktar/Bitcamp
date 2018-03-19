package step07;

import step07.scores.Score;

public class ExamX_1 { // Exam01_1
    // 사용자 정의 타입 활용, 메소드 미적용 상태
    public static void main(String[] args) {
        Score score = new Score();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 80;
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum/3f;
        System.out.printf("%d %d %d %d %.1f", score.kor, score.eng, score.math, score.sum, score.average);
    }
}