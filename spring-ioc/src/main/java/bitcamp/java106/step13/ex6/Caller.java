package bitcamp.java106.step13.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {
    @Autowired X x;
    
    public void test() {
        int res = x.m1(10, 2);
        System.out.println("res : " + res);
        
        res = x.m1(10, 0);
        System.out.println("res : " + res);
    }
}
