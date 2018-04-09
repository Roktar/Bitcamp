package step21.ex2;

// 예외처리 적용 후
public class Calculator3 {
    public static int compute(String op, int a, int b) {
        switch(op) {
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : return a/b;
            case "%" : return a%b;
            default:
                // 유효하지않은 연산자인 경우
                // throws 명령을 사용하여 예외를 만들 수 있다.
                throw new RuntimeException("해당 연산자는 지원하지 않습니다.");
        }
    }
}
