package step07;

import step07.calculators.Calculator4;

public class ExamY_4 { //Exam03_3
        
    public static void main(String[] args) {
        
        // 외부로부터 인스턴스의 주소를 받지 않고 계산한다.
        Calculator4 c = new Calculator4(); // 식 1
        Calculator4 c2 = new Calculator4(); // 식 2
        
        // 식1) 2+3-1*7/3
        c.plus(2);
        c.plus(3);
        c.minus(1);
        c.multiply(7);
        c.divide(3);
        
        System.out.println(c.result);
        
        // 식2)3*2+7/4-5
        c2.plus(3);
        c2.multiply(2);
        c2.plus(7);
        c2.divide(4);
        c2.minus(5);
        
        // 각 객체를 만들어 그 안에 데이터를 넣고 보관한다.

        System.out.println(c2.result);
    }
}