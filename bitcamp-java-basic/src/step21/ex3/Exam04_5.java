package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;
// 다형적 변수의 특징을 이용, 여러 예외를 하나의 catch에서 처리
public class Exam04_5 {
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
        
        try {
            m(1);
        } catch(Exception e) {
            
        } // 위에 나열된 모든 Exception들은 Exception 클래스를 상속받은 것이기때문에
        // Exception 하나로 전부 처리할 수 있따.
    }
}
