// 트랜잭션 - 오토커밋
package step25.ex7;

import java.sql.DriverManager;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Class.forName("org.mariadb.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        
        System.out.println("DBMS와의 연결 완료 - 자동커밋 해제");
        
        con.setAutoCommit(false);
        
        java.sql.PreparedStatement stmt = con.prepareStatement("insert into ex_board(bno, titl, cont, rdt) values(?,?,?,now())");

        stmt.setInt(1, 111);
        stmt.setString(2, "1111");
        stmt.setString(3, "REWQ");
        stmt.executeUpdate();
        System.out.println("insert complete");

        stmt.setInt(1, 112);
        stmt.setString(2, "1111");
        stmt.setString(3, "REWQ");
        stmt.executeUpdate();
        System.out.println("insert complete");

        // 게시물 번호가 중복될 경우 에러가 발생
        // 단, 앞서 입력했던 2개는 정상적으로 반영된다. ==> Auto Commit이 활성화되어서 이미 DB에 반영되었기때문
        stmt.setInt(1, 113);
        stmt.setString(2, "1111");
        stmt.setString(3, "REWQ");
        stmt.executeUpdate();
        System.out.println("insert complete");
        
        con.commit();

        con.close();
    }

}
