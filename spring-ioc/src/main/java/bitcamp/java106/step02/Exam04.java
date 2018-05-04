package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bitcamp.java106.BeanUtils;

// 익명객체
public class Exam04 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step02/application-context-04.xml");
        
        BeanUtils.printBeanNames(iocContainer);
        
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#0");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#1");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#2");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#3");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#4");
        
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Engine#0");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Engine#1");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Engine#2");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Engine#3");
    }
}
