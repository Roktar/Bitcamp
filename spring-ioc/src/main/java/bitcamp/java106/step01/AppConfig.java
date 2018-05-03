package bitcamp.java106.step01;

import org.springframework.context.annotation.Bean;

// AnnotationConfigApplicationContext에서 사용할 Spring 설정 정보를 제공하는 클래스
public class AppConfig {
    @Bean("c1") // bean(객체)를 반환하는 메소드
    public Car getCar() {
        Car c = new Car();
        c.setMaker("비트자동차");
        c.setModel("티코");
        c.setCc(1980);
        
        return c;
    }
}
