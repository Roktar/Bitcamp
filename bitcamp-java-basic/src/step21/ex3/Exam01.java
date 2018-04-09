package step21.ex3;

public class Exam01 {
    static void m() {
        // 예외를 호출자에게 알려주는 문법
        throw new RuntimeException("예외 발생");
    }
    public static void main(String[] args) {
        try {
            m();
        } catch(RuntimeException e) {
            // 예외발생 시, catch문에서 적절한 조치를 취함.
            System.out.println(e.getMessage());
        }
    }
}
