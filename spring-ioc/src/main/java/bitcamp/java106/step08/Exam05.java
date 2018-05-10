// 의존객체주입 자동화 - 생성자에 의존객체 주입
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam05 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step08/application-context-05.xml");
        
        System.out.println(iocContainer.getBean("c1"));
    }
}
