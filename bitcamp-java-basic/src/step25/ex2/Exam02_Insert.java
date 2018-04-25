package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//PreparedStatement 적용
public class Exam02_Insert {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        System.out.print("제목? ");
        String title = sc.nextLine();
        System.out.print("내용? ");
        String content = sc.nextLine();
        
        // PreparedStatement를 사용하여 sql문 적용
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO ex_board(titl, cont, rdt) VALUES(?, ?, now())");
        
        pstmt.setString(1, title);
        pstmt.setString(2, content);

        // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
        int i = pstmt.executeUpdate();
        System.out.printf("%d개 입력되었습니다.", i);
        
        pstmt.close();
        con.close();
        sc.close();
    }

}
