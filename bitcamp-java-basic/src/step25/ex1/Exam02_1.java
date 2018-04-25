package step25.ex1;

import java.sql.DriverManager;

public class Exam02_1 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 인자를 3개로
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        con.close();
    }

}
