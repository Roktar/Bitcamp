package step25.ex2;

import java.sql.DriverManager;
import java.util.Scanner;

public class Exam01_Delete {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료");
        
        System.out.print("삭제할 게시물 번호? ");
        String no = sc.nextLine();
        
        // SQL문을 서버로 보내기위해 해당 기능을 담당하는 객체의 주소를 얻어온다.
        // 반환값 : SQL문을 DBMS의 형식에 따라 인코딩하고 서버에 전달하는 일을 하는 객체를 준비한다.
        java.sql.Statement stmt = con.createStatement();
        
        // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
        int i = stmt.executeUpdate("Delete FROM ex_board where bno = " + no  );
        System.out.printf("%d개 삭제되었습니다.", i);
        
        con.close();
    }
}
