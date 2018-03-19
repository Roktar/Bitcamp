package step07;

import step07.calculators.Calculator3;

public class ExamY_5 { // Exam03_4
        
    public static void main(String[] args) {
        
        // 계산결과를 개별적으로 관리 : 개별적으로 관리할 변수를 인스턴스 변수로 생성
        
        Calculator3 c = new Calculator3(); // 식 1
        Calculator3 c2 = new Calculator3(); // 식 2
        
        // 식1) 2+3-1*7/3
        Calculator3.plus(c, 2);
        Calculator3.plus(c, 3);
        Calculator3.minus(c, 1);
        Calculator3.multiply(c, 7);
        Calculator3.divide(c, 3);
        
        System.out.println(c.result);
        
        // 식2)3*2+7/4-5
        Calculator3.plus(c2, 3);
        Calculator3.multiply(c2, 2);
        Calculator3.plus(c2, 7);
        Calculator3.divide(c2, 4);
        Calculator3.minus(c2, 5);
        
        // 각 객체를 만들어 그 안에 데이터를 넣고 보관한다.

        System.out.println(c2.result);
    }
}