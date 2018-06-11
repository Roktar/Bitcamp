package step25.ex7;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam01_List {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        Class.forName("org.mariadb.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/java106db", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        // SQL문을 서버로 보내기위해 해당 기능을 담당하는 객체의 주소를 얻어온다.
        // 반환값 : SQL문을 DBMS의 형식에 따라 인코딩하고 서버에 전달하는 일을 하는 객체를 준비한다.
        java.sql.Statement stmt = con.createStatement();
        
        
        // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
        ResultSet rs = stmt.executeQuery("SELECT * FROM ex_board");
        // 단, 아직 서버에서 결과를 가져온 것은 아니다.
        
        while(rs.next())
            System.out.printf("%d, %s, %s\n", rs.getInt("bno"), rs.getString("titl"), rs.getString("rdt"));
        
        rs.close();
        stmt.close();
        con.close();
    }

}
