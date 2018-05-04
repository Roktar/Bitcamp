package bitcamp.java106;

import org.springframework.context.ApplicationContext;

public class BeanUtils {
    public static void printBeanList(ApplicationContext iocContainer) {
        // IoC 컨테이너에 들어있는 객체를 알아내기
        System.out.println("--------------------------------------------------");
        System.out.println("생성된 Bean(객체)의 갯수 : " + iocContainer.getBeanDefinitionCount());
        
        String[] beanNames = iocContainer.getBeanDefinitionNames();
        for(String n : beanNames)
            System.out.printf("%s = %s\n", n, iocContainer.getBean(n).getClass());
        System.out.println("--------------------------------------------------");
    }
    
    public static void printBeanNames(ApplicationContext iocContainer) {
        System.out.println("[생성된 빈 이름 목록]");
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names)
            System.out.println(name);
        System.out.println("--------------------------------------------------");
    }
    
    public static void printBeanAliases(
            ApplicationContext iocContainer, String beanName) {
        System.out.printf("['%s' 빈의 별명 목록]\n", beanName);
        String[] aliases = iocContainer.getAliases(beanName);
        for (String alias : aliases) {
            System.out.println(alias);
        }
    }
}
