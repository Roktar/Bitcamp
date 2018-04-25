package step25.ex4;

import java.util.List;

public class Exam01_List {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        DataSource dataSource = new DefaultDataSource();
        
        BoardDao boardDao = new BoardDao(dataSource);
        
        try {
            List<Board> list = boardDao.list();

            for(Board board : list) 
                System.out.printf("%d, %s, %s\n", board.getNo(), board.getTitle(), board.getRegisteredDate());
        } catch(Exception e) {
            
        }
    }
}
