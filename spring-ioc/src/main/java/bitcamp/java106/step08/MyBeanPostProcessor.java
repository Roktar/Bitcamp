package bitcamp.java106.step08;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
    public MyBeanPostProcessor() {
        System.out.println("Processor 생성자 호출");
    }
    
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before() 함수 호출");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
    
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after() 함수 호출");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
