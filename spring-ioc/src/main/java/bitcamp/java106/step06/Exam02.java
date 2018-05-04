package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bitcamp.java106.BeanUtils;

// SPRING IOC 처리
public class Exam02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step06/application-context-02.xml");
        
        System.out.println(iocContainer.getBean("d1"));
    }
}
