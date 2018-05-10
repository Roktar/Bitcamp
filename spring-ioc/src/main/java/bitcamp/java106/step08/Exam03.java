
// 의존객체주입 자동화 - BeanPostProcessor 동작원리
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam03 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step08/application-context-03.xml");
        
        System.out.println(iocContainer.getBean("c1"));
    }
}
