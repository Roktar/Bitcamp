package step25.ex4;

import java.util.Scanner;

public class Exam01_Update {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        DataSource dataSource = new DefaultDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        BoardDao boardDao = new BoardDao(dataSource);
        
        System.out.print("변경할 게시물 번호? ");
        board.setNo( Integer.parseInt(sc.nextLine()) );
        
        System.out.print("제목? ");
        board.setTitle(sc.nextLine());
        System.out.print("내용? ");
        board.setContent(sc.nextLine());
        
        int c = boardDao.update(board);
    }
}
