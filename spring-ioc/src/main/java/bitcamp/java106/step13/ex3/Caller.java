package bitcamp.java106.step13.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {
    @Autowired X x;
    
    public void test() {
        System.out.println("test  start");
        int res = x.m1(10, 2);
        
        res = x.m1(10, 0);
        System.out.println("res : " + res);
        System.out.println("test  end");
    }
}
