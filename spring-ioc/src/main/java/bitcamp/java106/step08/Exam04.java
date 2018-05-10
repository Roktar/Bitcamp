// 의존객체주입 자동화 - 인스턴스 변수에 @Autowired 부착
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam04 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step08/application-context-04.xml");
        
        System.out.println(iocContainer.getBean("c1"));
    }
}
