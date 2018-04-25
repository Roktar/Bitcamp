package step25.ex4;

import java.util.Scanner;

//PreparedStatement 적용
public class Exam01_Insert {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        try {
            Board board = new Board();
            
            DataSource dataSource = new DefaultDataSource();
            BoardDao boardDao = new BoardDao(dataSource);
            
            System.out.print("제목? ");
            board.setTitle(sc.nextLine());
            System.out.print("내용? ");
            board.setContent(sc.nextLine());
            
            int c = boardDao.insert(board);
            
            System.out.printf("%d개 입력완료!", c);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        sc.close();
    }
}
