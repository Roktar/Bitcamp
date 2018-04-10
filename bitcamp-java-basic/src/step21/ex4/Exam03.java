package step21.ex4;
// Exception 던지고 받기
public class Exam03 {
    static void m1() {
        m2();
        System.out.println("call m1");
        // - 상위 호출자에게 전달하려면 해당 예외를 메소드 선언부에 기술해야한다.
    }
    
    static void m2() {
        m3();
        System.out.println("call m2");
        // - 상위 호출자에게 전달하려면 해당 예외를 메소드 선언부에 기술해야한다.
    }
    
    static void m3() {
        m4();
        System.out.println("call m3");
        // - 상위 호출자에게 전달하려면 해당 예외를 메소드 선언부에 기술해야한다.
        // 단, RuntimeException은 던지는 해당 메소드에서는 선언부에 기술할 필요는 없다
        // 그렇기때문에 해당 예외를 받는 모든 메소드들도 어떤 예외가 발생하는 지 구체적으로 기술되어
        // 있지 않기에 고민할 필요 없이 throws를 안붙여도 된다.
        // 단, m4예외가 발생되면 상위 호출자에게 예외가 던져질 것이다.
    }
    
    static void m4() {
        throw new RuntimeException("m4에서 예외 발생");
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
        // try catch문이 없으면 에러 : catch로 에러를 처리해야하는데 처리문이 없어서 에러남.
        // 하지만 RuntimeException은 구체적으로 어떤 예외가 발생되는 지 알수 없어서 에러처리문구를 생략해도 에러가 안난다.
        // 이게 문제가 될 수 있다.
        
    } // RuntimeException 계열의 예외를 던질 때, 호출경로에 있는 메소드들에 throws를 안붙여도된다.
      // 처리하고싶은 곳에서 catch를 받으면 되는 것이다.
      // 조용히 예외를 던지는 것과 같다.
}
