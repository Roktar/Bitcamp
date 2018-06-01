package step12;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    
    // 서블릿 컨테이너가 웹 어플리케이션을 시작할 때 이 객체의 이 메소드를 호출.
    @Override
    public void contextInitialized(ServletContextEvent sce) {
     // 서블릿컨테이너가 본격적으로 서블릿을 실행하기 전에 필요한 도구를 준비시키는 코드를 위치시킨다.
        System.out.println("------- MyServletContextListener의 init메소드");
    }
}
// 단, 단순히 구현한다고해서 서블릿컨테이너가 찾는 것은 아니다.
// 즉, 매핑을 해야한다는 얘기다.
// 매핑은 어노테이션 부착 혹은 xml 파일에 추가하는 방법이 있다.
