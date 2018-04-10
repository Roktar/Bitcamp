package step21.ex4;
// Exception 던지고 받기
public class Exam02 {
    static void m1() throws Exception {
        m2();
        System.out.println("call m1");
        // - 상위 호출자에게 전달하려면 해당 예외를 메소드 선언부에 기술해야한다.
    }
    
    static void m2() throws Exception {
        m3();
        System.out.println("call m2");
        // - 상위 호출자에게 전달하려면 해당 예외를 메소드 선언부에 기술해야한다.
    }
    
    static void m3() throws Exception {
        m4();
        System.out.println("call m3");
        // - 상위 호출자에게 전달하려면 해당 예외를 메소드 선언부에 기술해야한다.
    }
    
    static void m4() throws Exception {
        throw new Exception("m4에서 예외 발생");
        // main에 예외 전달 방법
        // - 상위 호출자에게 전달하려고하며ㅑㄴ catch를 써서는 안된다.
    }
    
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    } // 예외ㅏ를 전달할 때는 거쳐가는 모든 메소드들에 throws 예외타입 을 적어야한다.
      // 하지만 어쩔 수 없으니 그냥 다 적어야한다.
}
