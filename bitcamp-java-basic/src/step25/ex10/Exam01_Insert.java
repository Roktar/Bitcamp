package step25.ex10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import step25.ex10.service.BoardService;

//commit test
public class Exam01_Insert {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("step25/ex10/application-context.xml");

        String[] names = iocContainer.getBeanDefinitionNames();
        
        for(String name : names) 
            System.out.println(name);
        
        BoardService boardService = iocContainer.getBean(BoardService.class);
                
        Board b1 = new Board();
        b1.setNo(181);
        b1.setTitle("111");
        b1.setContent("asd");
        
        Board b2 = new Board();
        b2.setNo(172);
        b2.setTitle("111");
        b2.setContent("asd");
        
        Board b3 = new Board();
        b3.setNo(183);
        b3.setTitle("111");
        b3.setContent("asd");
 
        boardService.test1(b1, b2, b3); // 트랜잭션 매니저가 등록된 메소드
        boardService.test2(b1, b2, b3); // 트랜잭션 매니저가 등록안된 메소드
    }
}
