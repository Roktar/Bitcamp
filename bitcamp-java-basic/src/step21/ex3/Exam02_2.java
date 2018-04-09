package step21.ex3;

public class Exam02_2 {
    static void m() throws Throwable {
        throw new RuntimeException();
    }
    
    static void m2() {
        throw new RuntimeException(); 
    }
    // throws를 사용하지 않아도 예외를 던질 수 있다.
    // 이는 RuntimeException만 해당하는 것으로 
    
    public static void main(String[] args) throws Throwable {
        try {
            m();
        } catch(RuntimeException e) {
            // 예외발생 시, catch문에서 적절한 조치를 취함.
            System.out.println(e.getMessage());
        }
    }
}
