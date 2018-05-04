package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bitcamp.java106.BeanUtils;

// SPRING IOC 처리
public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step02/application-context-01.xml");
        
        BeanUtils.printBeanList(iocContainer);
    }
}
