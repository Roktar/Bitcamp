package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam03_1 {
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
    // 던지는 예외를 하나로 퉁치기(모두 Exception 클래스의 하위클래스들)
    static void m2(int i) throws Exception {
        if(i==0)
            throw new Exception();
        else if(i==1)
            throw new RuntimeException();
        else if(i==2)
            throw new SQLException();
        else
            throw new IOException();
    }
    
    public static void main(String[] args) throws Throwable {
        try {
            m();
        } catch(RuntimeException e) {
            // 예외발생 시, catch문에서 적절한 조치를 취함.
            System.out.println(e.getMessage());
        }
    }
}
