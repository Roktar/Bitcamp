package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// INSTANCE METHOD 호출
public class Exam04 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step06/application-context-04.xml");
        
        System.out.println(iocContainer.getBean("c1"));
    }
}
