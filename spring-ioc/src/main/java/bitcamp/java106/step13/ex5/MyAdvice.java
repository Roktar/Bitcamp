package bitcamp.java106.step13.ex5;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // 이 어노테이션은 선언된 현재 클래스의 객체를 가리킨다.
public class MyAdvice {

    @Before("execution(* bitcamp.java106.step13.ex5.X.*(..)) and args(a,b)")
    public void doBefore(int a, int b) {
        System.out.printf("MyAdvice.doBefore() : %d, %d\n", a, b);
    }
    
    public void doAfter() {
        System.out.println("MyAdvice.doAfter()");
    }
    // 타겟 객체의 메소드를 실행한 후 그 결과를 받기
    @AfterReturning(pointcut="execution(* bitcamp.java106.step13.ex5.X.*(..))", returning="returnValue")
    public void doAfterReturning(Object returnValue) {
        System.out.println("MyAdvice.doAfterReturning() : " + returnValue);
    }
    // 예외발생 시 예외객체 받기
    @AfterThrowing(pointcut="execution(* bitcamp.java106.step13.ex5.X.*(..))", throwing="error")
    public void doAfterThrowing(Exception error) {
        System.out.println("MyAdvice.doAfterThrowing()" + error.getMessage());
    }
}
