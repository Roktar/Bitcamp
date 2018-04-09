package step21.ex3;

public class Exam02_1 {
    static void m() throws Throwable {
        // 예외를 호출자에게 알려주는 문법
        throw new Throwable();
    }
    static void m2() throws Error {
        throw new Error(); // 던질 수는 있지만 사용하지 말 것.
    }
    
    static void m3() {
        throw new Error();
    } // Error 계열의 오류는 throws를 적지 않아도 된다.
    
    static void m4() throws Exception {
        throw new Exception();
    } // 개발자들이 사용하는 예외 클래스
    
    static void m5() throws Exception {
        throw new String();
    } // 불가, Throwable 타입의 객체만 던질 수 있다.
    
    public static void main(String[] args) throws Throwable {
        try {
            m();
        } catch(RuntimeException e) {
            // 예외발생 시, catch문에서 적절한 조치를 취함.
            System.out.println(e.getMessage());
        }
    }
}
