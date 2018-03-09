package step04;

public class Exam03_6 {
    public static void main(String[] args) {
        boolean r;
        int r2;
        //r = 10 && 20; // 피연산자가 boolean이 아닌 int
        r2 = 10 & 20; // NO ERROR
        System.out.println(r2);

        // float r3 = 10.2f & 20.3f; // 피연산자가 정수가 아닌 float
    }
}