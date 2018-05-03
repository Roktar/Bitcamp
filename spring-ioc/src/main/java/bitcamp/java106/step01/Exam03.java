package bitcamp.java106.step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// SPRING IOC 처리
public class Exam03 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        // 
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car3 = (Car) iocContainer.getBean("c1");
        System.out.println(car3);

    }
}
