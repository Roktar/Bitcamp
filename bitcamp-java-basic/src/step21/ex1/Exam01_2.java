package step21.ex1;

// 예외처리 적용 전
public class Exam01_2 {
    public static void main(String[] args) {
        int result = Calculator.compute("+", 100, 200);
        
        if(result == -1)
            System.out.println("유효하지않은 연산");
        else
            System.out.println(result);
        
        result = Calculator.compute("-", 6, 7);
        
        if(result == -1)
            System.out.println("유효하지않은 연산");
        else
            System.out.println(result);
    }
}
