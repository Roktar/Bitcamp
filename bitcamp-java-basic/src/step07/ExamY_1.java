package step07;

import step07.calculators.Calculator;

public class ExamY_1 { // Exam01_2
        
    public static void main(String[] args) {
        int res = 0;
        
        // 2 + 3 - 1 * 7 / 3 = ?
        // 연산자 우선순위를 고려하지않고 순서대로 계산할 것.
        
        res = Calculator.plus(2, 3);
        res = Calculator.minus(res, 1);
        res = Calculator.multiply(res, 7);
        res = Calculator.divide(res, 3);
        
        System.out.println(res);
    }
}