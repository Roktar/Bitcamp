package bitcamp.java106.step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bitcamp.java106.BeanUtils;

// SPRING IOC 처리
public class Exam03 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step04/application-context-03.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        System.out.println(iocContainer.getBean("c2"));
    }
}
