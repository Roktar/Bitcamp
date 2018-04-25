package step25.ex2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam01_View {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        // SQL문을 서버로 보내기위해 해당 기능을 담당하는 객체의 주소를 얻어온다.
        // 반환값 : SQL문을 DBMS의 형식에 따라 인코딩하고 서버에 전달하는 일을 하는 객체를 준비한다.
        java.sql.Statement stmt = con.createStatement();
        
        System.out.print("조회할 게시글 번호? ");
        int no = sc.nextInt();
        sc.nextLine();
        
        // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
        ResultSet rs = stmt.executeQuery("SELECT * FROM ex_board where bno = " + no );
        // 단, 아직 서버에서 결과를 가져온 것은 아니다.
                
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
