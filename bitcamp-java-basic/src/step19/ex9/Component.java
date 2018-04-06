package step19.ex9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 생명주기 : 여기서는 RUNTIME동안 살아있도록 지정
public @interface Component {

    String value(); // Component 주석 생성

}
