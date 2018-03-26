package step11.ex13;

public class Exam01_1 {
    
    // class 문법을 이용하여 병원 고객을 추상화했다.
    static class Customer {
        String name;
        int age, weight, height;
    }
    
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.name = "홍길동";
        c1.age = 300;
        c1.weight = 100;
        c1.height = -50;
        // 문제점
        // - 단, 각각의 값이 인스턴스 변수에 들어갈 수 있는 값이기에 컴파일 오류는 발생하지않는다.
        // 1. 위의 데이터는 인간의 데이터로서 유효한 값은 아니다.
        // - 환자를 추상화시킨 목적을 상실한 것으로 추상화가 무너졌다.
        
        
    }
    
}
