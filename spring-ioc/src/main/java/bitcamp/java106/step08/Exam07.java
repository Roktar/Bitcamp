// 의존객체주입 자동화 - 같은 타입의 의존객체가 여러개 있을 때 
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam07 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step08/application-context-07.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        BeanUtils.printBeanNames(iocContainer);
    }
}
