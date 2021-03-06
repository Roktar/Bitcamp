package bitcamp.java106.step13.ex4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// AOP 적용 후 

public class Exam01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step13/ex4/application-context-01.xml");
        
        String[] names = iocContainer.getBeanDefinitionNames();
        
        for(String name : names)
            System.out.println(iocContainer.getBean(name).getClass().getName());
        System.out.println("--------------------------------------------------------------------");
        
        try {
            Caller caller = (Caller) iocContainer.getBean(Caller.class);
            caller.test();
        } catch(Exception e) {
            System.err.println("에러");
        }
    }
}
