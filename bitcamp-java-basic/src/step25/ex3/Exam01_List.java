package step25.ex3;

import java.util.List;

public class Exam01_List {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        BoardDao boardDao = new BoardDao();
        
        List<Board> list = boardDao.list();
        
        System.out.println("--- LIST ---");
        try {
            for(Board board : list) 
                System.out.printf("%d, %s, %s\n", board.getNo(), board.getTitle(), board.getRegisteredDate());
        } catch(Exception e) {
            
        }
    }
}
