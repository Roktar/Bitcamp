package step07;

import step07.calculators.Calculator2;

public class ExamY_3 { // Exam03_2
        
    public static void main(String[] args) {
        
        // 클래스변슈는 하나기때문에 다음 두 개의 식을 개별적으로 동시에 할 수 없다.
        // 식1) 2+3-1*7/3
        // 식2)3*2+7/4-5
        
        Calculator2.plus(2);
        Calculator2.plus(3);
        Calculator2.minus(1);
        Calculator2.multiply(7);
        Calculator2.divide(3);
        
        System.out.println(Calculator2.result);
    }
}