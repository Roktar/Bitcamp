package step27;

// 아규먼트로 람다 쓰기
public class Exam04 {
    
    static interface Calculator {
        int compute(int a, int b);
    }
    
    static void test(Calculator c) {        
        System.out.println(c.compute(100, 200));
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 메소드가 1개인 인터페이스를 람다 표현식을 사용하여 구현
        
        System.out.println(new Calculator() {
            @Override
            public int compute(int a, int b) {
                return a+b;
            }
        }.compute(100, 200));
        
        test( (a, b) -> a+b );
    }
}
