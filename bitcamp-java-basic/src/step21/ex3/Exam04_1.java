package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;
// 예외 받아서 처리
public class Exam04_1 {
    // 던지는 예외를 메소드에 선언(모두 나열)
    static void m(int i) throws Exception, RuntimeException, SQLException, IOException  {
        if(i==0)
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
            m(1);
        } catch(IOException e) {
            
        } catch(SQLException e) {
            
        } catch(RuntimeException e) {
            
        } catch(Exception e) {
            
        }
        
    }
}
