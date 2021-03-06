package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao {
    
    public int delete(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try(
             java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");    
             PreparedStatement stmt = con.prepareStatement("Delete FROM pms_board where bno = ?");
            ) {
            
            stmt.setInt(1, no);
            
            return stmt.executeUpdate();
        }
    }
    
    public List<Board> selectList() throws Exception {
        List<Board> arr = new ArrayList<>();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try( 
             java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
             PreparedStatement stmt = con.prepareStatement("select bno, titl, cdt from pms_board");
             ResultSet rs = stmt.executeQuery();
           ) {
            while(rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setCreatedDate( rs.getDate("cdt"));
                arr.add(board);
            }
        }
        return arr;
    }
    
    public int insert(Board board) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try( 
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
           PreparedStatement pstmt = con.prepareStatement("INSERT INTO pms_board(titl, cont, cdt) VALUES(?, ?, now())");
           ) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
    
            // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
            return pstmt.executeUpdate();
        }
    }
    
    public int update(Board board) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
            PreparedStatement stmt = con.prepareStatement("Update pms_board SET titl=?, cont=?, cdt=now() where bno = ?"); 
            ) {        
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
                    
            // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
            return stmt.executeUpdate();
        }
    }
    
    public Board selectOne(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false","java106", "1111");
            PreparedStatement stmt = con.prepareStatement("select bno,titl,cont,cdt from pms_board where bno=?");) {
            
                stmt.setInt(1, no);
                
                try (ResultSet rs = stmt.executeQuery();) {
                    if (!rs.next()) 
                        return null;
                
                    Board board = new Board();
                    board.setNo(rs.getInt("bno"));
                    board.setTitle(rs.getString("titl"));
                    board.setContent(rs.getString("cont"));
                    board.setCreatedDate(rs.getDate("cdt"));
                    return board;
            }
        }
    }
}

//ver 31 - JDBC 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





