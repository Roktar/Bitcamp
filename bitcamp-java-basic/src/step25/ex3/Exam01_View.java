package step25.ex3;

import java.util.Scanner;

public class Exam01_View {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("조회할 게시글 번호? ");
        String no = sc.nextLine();

        try {
            BoardDao boardDao = new BoardDao();
            Board board = boardDao.view(no);
            
            if(board != null) {
                System.out.printf("게시글 번호 : %d\n", board.getNo());
                System.out.printf("게시글 제목 : %s\n", board.getTitle());
                System.out.printf("게시글 내용 : %s\n", board.getContent());
                System.out.printf("등록일자 : %s\n", board.getRegisteredDate());
            } else
                System.out.println("해당 번호의 게시물이 없습니다.");
        } catch(Exception e) { 
            e.printStackTrace();
        }
        
        sc.close();
    }
}
