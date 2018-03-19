package step07;

import step07.scores.Score3;

public class ExamX_3 { //Exam 03_1
    public static void main(String[] args) {
        Score3 score = new Score3();
        
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 80;
        
        score.calculate();
    }
} // 인스턴스 메소드를 사용했다. (별도로 외부에서 주소를 넣어주지않음)