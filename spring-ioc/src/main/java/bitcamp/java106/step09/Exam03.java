// 의존객체주입 자동화 - @Component 어노테이션 활용
package bitcamp.java106.step09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam03 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step09/application-context-03.xml");

        BeanUtils.printBeanNames(iocContainer);
    }
}
