package step25.ex2;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam02_List {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        PreparedStatement stmt = con.prepareStatement("select bno, titl, rdt from ex_board");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next())
            System.out.printf("%d, %s, %s\n", rs.getInt("bno"), rs.getString("titl"), rs.getString("rdt"));
        
        rs.close();
        stmt.close();
        con.close();
    }

}
