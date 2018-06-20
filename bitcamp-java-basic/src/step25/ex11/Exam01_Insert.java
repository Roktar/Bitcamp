package step25.ex11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import step25.ex11.service.BoardService;

//트랜잭션 정책 테스트
public class Exam01_Insert {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("step25/ex11/application-context.xml");

        String[] names = iocContainer.getBeanDefinitionNames();
        
        for(String name : names) 
            System.out.println(name);
        
        BoardService boardService = iocContainer.getBean(BoardService.class);

        Board b1 = new Board().setNo(201).setTitle("1111").setContent("xxxx");
        Board b2 = new Board().setNo(202).setTitle("1111").setContent("xxxx");
        Board b3 = new Board().setNo(203).setTitle("1111").setContent("xxxx");
        Board b4 = new Board().setNo(204).setTitle("1111").setContent("xxxx");
        Board b5 = new Board().setNo(205).setTitle("1111").setContent("xxxx");
        
        boardService.test1(b1, b2, b3, b4, b5);
 
    }
}
