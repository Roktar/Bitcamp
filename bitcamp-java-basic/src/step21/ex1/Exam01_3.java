package step21.ex1;

// 예외처리 적용 전
public class Exam01_3 {
    public static void main(String[] args) {
        int result = Calculator2.compute("+", 100, 200);
        
        if(result == -11111111)
            System.out.println("유효하지않은 연산");
        else
            System.out.println(result);
        
        result = Calculator2.compute("-", 6, 7);
        
        if(result == -11111111)
            System.out.println("유효하지않은 연산");
        else
            System.out.println(result);
        
        result = Calculator2.compute("+", -2078654356, 866533144);
        
        if(result == -1212121212)
            System.out.println("유효하지않은 연산");
        else
            System.out.println(result);
    }
}
