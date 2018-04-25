package step25.ex4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 데이터를 처리하는 코드를 별도의 클래스로 캡슐화
public class BoardDao {
    DataSource dataSource;
    
    public BoardDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    int delete(int no) throws Exception {

        try( 
             java.sql.Connection con = dataSource.getConnection(); // ConnectionProxy가 넘어옴.
             PreparedStatement stmt = con.prepareStatement("Delete FROM ex_board where bno = ?"); 
            ) {
            
             stmt.setInt(1, no);
            
            return stmt.executeUpdate();
        }
    }
    
    List<Board> list() throws Exception {
        List<Board> arr = new ArrayList<>();
                
        try( 
             java.sql.Connection con = dataSource.getConnection();
             PreparedStatement stmt = con.prepareStatement("select bno, titl, rdt from ex_board");
             ResultSet rs = stmt.executeQuery();
           ) {
            while(rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setRegisteredDate( rs.getDate("rdt"));
                arr.add(board);
            }
        }
        return arr;
    }
    
    int insert(Board board) throws Exception {
        
        Scanner sc = new Scanner(System.in);
                
        try( 
           Connection con = dataSource.getConnection();
           PreparedStatement pstmt = con.prepareStatement("INSERT INTO ex_board(titl, cont, rdt) VALUES(?, ?, now())");
           ) {
            pstmt.setString(1, board.title);
            pstmt.setString(2, board.content);
    
            // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
            return pstmt.executeUpdate();
        }
    }
    
    int update(Board board) throws Exception {
        try (
            java.sql.Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement("Update ex_board SET titl=?, cont=?, rdt=now() where bno = ?"); 
            ) {        
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
                    
            // Statement 객체를 사용하여 DBMS에 SQL문을 전송한다.
            return stmt.executeUpdate();
        }
    }
    
    Board view(String no) throws Exception {
        try (
                java.sql.Connection con = dataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM ex_board where bno = ?");
            ) {
            stmt.setString(1, no);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setRegisteredDate(rs.getDate("rdt"));
                
                return board;
            } else
                return null;
        }
    }
}
