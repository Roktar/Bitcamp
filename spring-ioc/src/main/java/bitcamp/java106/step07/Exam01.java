// 프로퍼티 에디터 - 기본 내장된 built-in 프로퍼티
package bitcamp.java106.step07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = null;
        
        iocContainer = new ClassPathXmlApplicationContext("bitcamp/java106/step07/application-context-01.xml");
        
        // String을 자동으로 Date 객체로 변환할 수 없어서 원래는 에러가 난다.
        System.out.println(iocContainer.getBean("c1"));
        System.out.println(iocContainer.getBean("c2"));
    }
}
