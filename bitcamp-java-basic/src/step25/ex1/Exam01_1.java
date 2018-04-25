package step25.ex1;

import java.sql.DriverManager;
import java.sql.SQLException;

// jdbc 드라이버 타입과 준비
public class Exam01_1 {

    public static void main(String[] args) throws SQLException {
        // 1) 드라이버 로딩
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        System.out.println("JDBC 드라이버 로드 & 등록");
        
        
        
        
    }
}
