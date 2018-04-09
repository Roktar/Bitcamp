package step20.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
// .class파일에도 남아있고 실행 중 추출이 가능하다.(유지정책 : RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation3 {
    String value();
}
