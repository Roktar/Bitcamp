package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;
// 예외 처리 후 마무리 작업
public class Exam05_1 {
    // 던지는 예외를 메소드에 선언(모두 나열)
    static void m(int i) throws Exception, RuntimeException, SQLException, IOException  {
        if(i<0)
            return;
        else if(i==0)
            throw new Exception();
        else if(i==1)
            throw new RuntimeException();
        else if(i==2)
            throw new SQLException();
        else
            throw new IOException();
    }
    
    public static void main(String[] args) throws Exception {
        // 예외를 처리하고싶지않은경우, 이전 호출자에게 책임을 넘길 수 있다.
        // main() 호출자 : JVM, JVM은 main 예외를 던지는 순간 실행을 멈춤
        // main의 호출자에게 책임을 떠넘기는 것은 바람직하지 않음.
        
        try {
            System.out.println("try {} ");

            m(0);
        } catch( RuntimeException | SQLException | IOException e) {
            // |(or)로 클래스 형식을 여러개 나열할 수 있다.
            System.out.println("catch 1");
        } catch (  Exception e ) {
            System.out.println("catch 2");
        } finally {
            // try문 내부의 모든 문장이 끝나면 무조건 한 번은 실행되는 문장
            System.out.println("finally");
        }
        
    }
}
