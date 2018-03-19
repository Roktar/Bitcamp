package step07;

import step07.calculators.Calculator2;

public class ExamY_2 { // Exam02_2
        
    public static void main(String[] args) {

        Calculator2.plus(2);
        Calculator2.plus(3);
        Calculator2.minus(1);
        Calculator2.multiply(7);
        Calculator2.divide(3);
        
        System.out.println(Calculator2.result);
    }
}