package bitcamp.java106.step10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig02 {
    @Bean
    public Car getCar() {
        Car c = new Car(null);
        c.setMaker("비트자동차");
        c.setModel("티코");
        c.setCc(890);
        c.setAuto(true);
        return c;
    }
    
    @Bean
    public Car Car2() {
        Car c = new Car(null);
        c.setMaker("비트자동차");
        c.setModel("티코");
        c.setCc(890);
        c.setAuto(true);
        return c;
    }
    
    public Car Car3() {
        Car c = new Car(null);
        c.setMaker("비트자동차");
        c.setModel("티코");
        c.setCc(890);
        c.setAuto(true);
        return c;
    }
}
