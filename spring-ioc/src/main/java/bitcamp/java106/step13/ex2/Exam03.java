package bitcamp.java106.step13.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// AOP 적용 후 

public class Exam03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step13/ex2/application-context-03.xml");
        
        String[] names = iocContainer.getBeanDefinitionNames();
        
        for(String name : names)
            System.out.println(iocContainer.getBean(name).getClass().getName());
        System.out.println("--------------------------------------------------------------------");
        
        Caller caller = (Caller) iocContainer.getBean(Caller.class);
        caller.test();
    }
}
