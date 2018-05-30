package bitcamp.java106.pms.support;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

public class WebApplicationContextUtils {
    // 실제 스프링 WebMVC 프레임워크에서는 
    // 웹 애플리케이션 별로 IoC 컨테이너를 관리한다.
    public static Map<ServletContext, ApplicationContext> containers = new HashMap<>();
    
    public static ApplicationContext getAppCtx(ServletContext ctx) {
        return containers.get(ctx);
    }
}
