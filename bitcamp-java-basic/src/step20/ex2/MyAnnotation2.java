package step20.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 해당 어노테이션은 컴파일 시에 제거된다.(정책이 SOURCE기에)
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation2 {
    String value();
}
