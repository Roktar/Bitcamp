package step21.ex2;

// 예외처리 적용 후
// - 메소드가 던지는 예외를 받는다.
public class Exam01_3 {
    public static void main(String[] args) throws Exception {
        
        try {
            int result = Calculator3.compute("#", 100, 200);
            
            if(result == -11111111)
                System.out.println("유효하지않은 연산");
            else
                System.out.println(result);

        } catch(RuntimeException e) {
            // try 블록 안에서 메소드를 호출하다가 발생된 예외를 
            // catch에서 파라미터로 받음
            System.out.println(e.getMessage());
        }
    }
}
