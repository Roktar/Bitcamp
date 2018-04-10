package step21.ex3;

import java.io.IOException;
import java.sql.SQLException;
// 예외 처리 후 마무리 작업
public class Exam05_2 {
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
    
    static void test() throws Exception {
        try {
            m(-1);
        } finally {
            System.out.println("정상실행 시");
        }
    }
    
    static void test2() throws Exception {
        try {
            m(0);
        } finally {
            System.out.println("예외 발생 시");
        }
    }
    
    public static void main(String[] args) throws Exception {        
        try {
            test(); 
        } catch (  Exception e ) {

        }
        
        try {
            test2(); 
        } catch ( Exception e ) {
        
        }
        
    }
}
