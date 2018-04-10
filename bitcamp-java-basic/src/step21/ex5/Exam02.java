package step21.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam02 {
    static Board read() throws RuntimeException {
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
    // RuntimeException이 던져지는 것은 알 수 있으나 그 예외가
    // 정확히 의미하는 바가 무엇인지 알아보기가 힘들다.
    
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
    // RuntimeException 계열 예외는 굳이 throws를 쓰지않아도 된다.
    // 하지만 해당 메소드를 사용하는 개발자에게 어떤 예외가 발생할 수 있는 지 명확하게
    // 제시해주는 것이 유지보수에 도움이 된다.
}
