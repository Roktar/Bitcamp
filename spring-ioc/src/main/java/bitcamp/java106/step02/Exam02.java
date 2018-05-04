package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bitcamp.java106.BeanUtils;

// SPRING IOC 처리
public class Exam02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step02/application-context-02.xml");
        
        BeanUtils.printBeanList(iocContainer);
        
        // bean에 name(별명) 이 지정된 경우, name으로도 빈을 꺼내올 수 있다.
        Car c1 = (Car) iocContainer.getBean("c1");
        Car c2 = (Car) iocContainer.getBean("c2");
        
        if(c1!=c2)
            System.out.println("c1 != c2");
        
        Car c3 = (Car) iocContainer.getBean("c3");
        
        if(c2 == c3)
            System.out.println("c1 == c2");
        
        System.out.println("c1 : " + c1);
        System.out.println("c2 : " + c2);
        System.out.println("c3 : " + c3);

        BeanUtils.printBeanAliases(iocContainer, "c5");
        BeanUtils.printBeanAliases(iocContainer, "c60");
        BeanUtils.printBeanAliases(iocContainer, "c70");
        
    }
}
