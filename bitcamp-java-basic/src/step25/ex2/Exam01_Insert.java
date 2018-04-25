package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Exam01_Insert {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        // SQL문을 서버로 보내기위해 해당 기능을 담당하는 객체의 주소를 얻어온다.
        // 반환값 : SQL문을 DBMS의 형식에 따라 인코딩하고 서버에 전달하는 일을 하는 객체를 준비한다.
        java.sql.Statement stmt = con.createStatement();
        
        System.out.print("제목? ");
        String title = sc.nextLine();
        
        System.out.print("내용? ");
        String content = sc.nextLine();
        
        String sql = String.format("INSERT INTO ex_board(titl, cont, rdt) values ('%s','%s',now())", title, content);
        
        // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
        int i = stmt.executeUpdate(sql);
        System.out.printf("%d개 입력되었습니다.", i);
        
        
        stmt.close();
        con.close();
        sc.close();
    }

}
