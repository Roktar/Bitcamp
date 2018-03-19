package step07.calculators;

public class Calculator3 {

    // 작업결과를 개별관리하고 싶을 때는 인스턴스 변수로 선언한다
    // 인스턴스 변수는 클래스가 로딩될 때 만들어지지않으며 new 명령이 필요하다.
    // 변수 선언 앞에 static을 붙이지 않는다.
    public int result = 0;
    
    // 여기서 result는 클래스 변수가 아니기에 인스턴스 주소를 통해 접근해야한다.
    public static void plus(Calculator3 c, int val) { 
        c.result += val; 
    }
    public static void minus(Calculator3 c, int val) {  c.result -= val; }
    public static void multiply(Calculator3 c, int val) { c.result *= val; }
    public static void divide(Calculator3 c, int val) { c.result /= val; }
}
