package step25.ex2;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam02_Update {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        // SQL문을 서버로 보내기위해 해당 기능을 담당하는 객체의 주소를 얻어온다.
        // 반환값 : SQL문을 DBMS의 형식에 따라 인코딩하고 서버에 전달하는 일을 하는 객체를 준비한다.
        PreparedStatement stmt = con.prepareStatement("\"Update ex_board SET titl=?, cont=? where bno = ?");

        System.out.print("변경할 게시글 번호?");
        String no = sc.nextLine();
        
        System.out.print("제목?");
        String title = sc.nextLine();
        System.out.print("내용?");
        String content = sc.nextLine();
        
        stmt.setString(1, title);
        stmt.setString(2, content);
        stmt.setString(3, no);
                
        // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
        int i = stmt.executeUpdate();
        System.out.printf("%d개 변경되었습니다.", i);
        
        con.close();
    }

}
