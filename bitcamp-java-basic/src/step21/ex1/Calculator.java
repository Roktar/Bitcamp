package step21.ex1;

// 예외처리 적용 전
public class Calculator {
    public static int compute(String op, int a, int b) {
        switch(op) {
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : return a/b;
            case "%" : return a%b;
            default:
                // 보통은 잘못된 연산일 경우,
                // 일반적인 계산 결과로 나올 수 없는 값을 지정한다.
                return -1;
                
        }
    }
}
