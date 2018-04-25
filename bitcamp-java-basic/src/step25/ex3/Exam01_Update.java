package step25.ex3;

import java.util.Scanner;

public class Exam01_Update {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        BoardDao boardDao = new BoardDao();
        
        System.out.print("변경할 게시물 번호? ");
        board.setNo( Integer.parseInt(sc.nextLine()) );
        
        System.out.print("제목? ");
        board.setTitle(sc.nextLine());
        System.out.print("내용? ");
        board.setContent(sc.nextLine());
        
        int c = boardDao.update(board);
    }
}
