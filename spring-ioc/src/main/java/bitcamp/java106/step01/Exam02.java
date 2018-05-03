package bitcamp.java106.step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// SPRING IOC 처리
public class Exam02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new FileSystemXmlApplicationContext("file:/C:\\Users\\Bit\\git\\Bitcamp\\spring-ioc\\src\\main\\java\\bitcamp\\java106\\step01\\application-context.xml");
        Car car = (Car)iocContainer.getBean("c1");
        System.out.println(car);
    }
}
