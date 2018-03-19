package step07.calculators;

public class Calculator2 {
    
    // 이 클래스에 들어있는 메소드들의 작업결과를 보관할 변수를 준비한다.
    // 클래스 변수는 new명령으로 생성하지않는다.
    // 클래스가 메모리에 로딩되면 자동으로 메소드 영역에 생성된다.
    public static int result = 0;
    
    // 다음 메소드들은 작업 결과를 클래스 변수에 보관한다.
    public static void plus(int val) { result += val; }
    public static void minus(int val) {  result -= val; }
    public static void multiply(int val) { result *= val; }
    public static void divide(int val) { result /= val; }
}
