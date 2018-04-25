package step25.ex1;

import java.sql.DriverManager;
import java.sql.SQLException;

// jdbc 드라이버 타입과 준비
public class Exam01_3 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1) 드라이버 로딩
        //new com.mysql.cj.jdbc.Driver();
                
        //java.sql.Driver driver = DriverManager.getDriver("jdbc:mysql:");
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Driver driver = DriverManager.getDriver("jdbc:mysql:");
        
        
        
        
        if(driver != null)
            System.out.println("드라이버 로드");
        else
            System.out.println("드라이버 로드 실패");
        
        // 2) 
        
        
        
        
    }
}
