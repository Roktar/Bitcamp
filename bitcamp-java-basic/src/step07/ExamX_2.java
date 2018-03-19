package step07;

import step07.scores.Score2;

public class ExamX_2 { // Exam02_1
    public static void main(String[] args) {
        Score2 score = new Score2();
        Score2 score2 = new Score2();
        
        score2.name = "홍길동";
        score2.kor = 100;
        score2.eng = 90;
        score2.math = 80;
//        score2.calculate();
        
        score.calculate(score2);
        
//        score2.print();
    }
} // 클래스 메소드를 인스턴스명으로 불러와서 사용했다. 하지만 굳이 이 방법을 쓸 필요는 없다.