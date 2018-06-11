package step25.ex8;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//commit test
public class Exam01_List {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("step25/ex8/application-context.xml");
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
                
        List<Board> list = boardDao.selectList();
        for(Board bd : list)
            System.out.printf("%d %s %s\n", bd.getNo(), bd.getTitle(), bd.getRegisteredDate());
    }
}
