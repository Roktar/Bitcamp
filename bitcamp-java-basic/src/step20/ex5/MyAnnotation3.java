package step20.ex5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Array
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation3 {
    // 배열 프로퍼티의 기본 값을 지정할 때,
    // 중괄호를 사용할 수 있다.
    // 단, 배열의 값이 한 개인 경우에는 
    // 중괄호 생략이 가능.
    String[] v1() default {"가나다", "라마바"};
    int[] v2() default 100;
    float[] v3() default 3.14f;
}
