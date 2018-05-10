// 의존객체주입 자동화 - @Autowired 어노테이션 활용
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step08/application-context-01.xml");
        
        System.out.println(iocContainer.getBean("c1"));
    }
}
