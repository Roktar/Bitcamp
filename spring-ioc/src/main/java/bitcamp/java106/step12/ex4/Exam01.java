package bitcamp.java106.step12.ex4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;
import bitcamp.java106.step12.Board;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step12/ex4/application-context.xml");
        
        BeanUtils.printBeanNames(iocContainer);
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        //1) 게시물 입력
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        boardDao.insert(board);
        
        //2) 게시물 목록 조회
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 5);
        
        List<Board> list = boardDao.selectList(map);
        for (Board b : list) {
            System.out.printf("%d, %s, %s\n", 
                    b.getNo(),
                    b.getTitle(),
                    b.getRegisteredDate());
        }
    }
}
