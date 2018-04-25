package step25.ex2;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam02_View {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM ex_board where bno = ?");
        
        System.out.print("조회할 게시글 번호? ");
        int no = sc.nextInt();
        sc.nextLine();
        stmt.setInt(1, no);
        
        ResultSet rs = stmt.executeQuery();
                
        if(rs.next()) {
            System.out.printf("게시글번호 : %d\n", rs.getInt("bno"));
            System.out.printf("게시글 제목 : %s\n", rs.getString("titl"));
            System.out.printf("게시글 내용 : %s\n", rs.getString("cont"));
            System.out.printf("등록일자 : %s\n", rs.getString("rdt"));
        } else
            System.out.println("해당 번호의 게시물이 없습니다.");
        
        rs.close();
        stmt.close();
        con.close();
        sc.close();
    }
}
