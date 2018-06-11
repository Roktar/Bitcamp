package step25.ex8;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//commit test
public class Exam01_Insert {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("step25/ex8/application-context.xml");
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        Board board = new Board();
        board.setNo(141);
        board.setTitle("asdf");
        boardDao.insert(board);
        System.out.println("- " + board.getNo() + "번 게시물 입력");

        board.setNo(142);
        board.setTitle("asdf");
        boardDao.insert(board);
        System.out.println("- " + board.getNo() + "번 게시물 입력");
        
        board.setNo(141);
        board.setTitle("asdf");
        boardDao.insert(board);
        System.out.println("- " + board.getNo() + "번 게시물 입력");
    }
}
