package step07;


class Student { // 사용자 정의 데이터 타입 설계
    String name;
    int age;
    String email;
    float weight;
    float height;
    String tel;
}

class Calculator {
    public static int plus(int a, int b) { return a+b; }
    public static int minus(int a, int b) { return a-b; }
    public static int multiply(int a, int b) { return a*b; }
    public static int divide(int a, int b) { return a/b; }
}

public class Exam01_1 {
        
    public static void main(String[] args) {
        Student ref = new Student();
        ref.name = "홍길동";
        ref.tel = "111-1111";
        ref.age = 20;

        int a = Calculator.plus(100, 200);

        System.out.println("OK");
    }
}