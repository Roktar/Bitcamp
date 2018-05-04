package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bitcamp.java106.BeanUtils;

// SPRING IOC 처리
public class Exam03 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step02/application-context-03.xml");
        BeanUtils.printBeanNames(iocContainer);
        Car obj1 = (Car) iocContainer.getBean("c1");
        Car obj2 = (Car) iocContainer.getBean("c1");
        if(obj1 == obj2)
            System.out.println("obj1 == obj2");
        
        Car obj3 = (Car) iocContainer.getBean("c2");
        Car obj4 = (Car) iocContainer.getBean("c2");
        if(obj1 == obj2)
            System.out.println("obj3 == obj4");
        
        Car obj5 = (Car) iocContainer.getBean("c3");
        Car obj6 = (Car) iocContainer.getBean("c3");
        if(obj5 != obj6)
            System.out.println("obj3 != obj4");
    }
}
