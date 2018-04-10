package step21.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam01 {
    static Board read() {
        try ( Scanner sc = new Scanner(System.in); ) {
            Board board = new Board();
            
            System.out.print("번호> ");
            board.setNo( Integer.parseInt(sc.nextLine()));
            System.out.print("제목> ");
            board.setTitle(sc.nextLine());
            System.out.print("내용> ");
            board.setContent(sc.nextLine());
            System.out.print("등록일> ");
            board.setCreatedDate( Date.valueOf(sc.nextLine()) );
            
            return board;
        }
    }
    
    public static void main(String[] args) {
        try {
            Board board = read();
            System.out.printf("번호 : %d\n", board.getNo());
            System.out.printf("제목 : %s\n", board.getTitle());
            System.out.printf("내용 : %s\n", board.getContent());
            System.out.printf("등록일 : %s\n", board.getCreatedDate());
        } catch(RuntimeException e) {
            System.out.println("오류 발생");
        }
    }
}
