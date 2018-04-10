package step21.ex5;
// 예외에 의미 부여
import java.sql.Date;
import java.util.Scanner;

public class Exam03 {
    // 실무에서는 예외의 의미를 직관적으로 알 수 있도록
    // 클래스명대로 사용하지않고 기존에 있는 예외를 상속받아 의미있는 이름으로
    // 서브클래스를 정의한 후 그 클래스를 사용한다.
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
        } catch (Exception e) {
            throw new BoardException("입력 중 오류 발생", e);
        } // 여기서는 RuntimeException을 상속받은 BoardException을 만들었으며
          // Board에서 예외가 발생했음을 직관적으로 알 수 있따.
    } 

    
    public static void main(String[] args) {
        try {
            Board board = read();
            System.out.printf("번호 : %d\n", board.getNo());
            System.out.printf("제목 : %s\n", board.getTitle());
            System.out.printf("내용 : %s\n", board.getContent());
            System.out.printf("등록일 : %s\n", board.getCreatedDate());
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    // RuntimeException 계열 예외는 굳이 throws를 쓰지않아도 된다.
    // 하지만 해당 메소드를 사용하는 개발자에게 어떤 예외가 발생할 수 있는 지 명확하게
    // 제시해주는 것이 유지보수에 도움이 된다.
}
