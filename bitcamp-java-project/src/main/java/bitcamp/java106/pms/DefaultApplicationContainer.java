package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

public class DefaultApplicationContainer implements ApplicationContainer {
    
    ApplicationContext iocContainer;
    
    public DefaultApplicationContainer() throws Exception {
/*        // IoC 컨테이너에서 자동으로 생성되지않는 객체를 미리 준비함.
        HashMap<String, Object> objMap = new HashMap<>();
        objMap.put("dataSource", new DefaultDataSource("jdbc.properties"));

        // Mybatis의 SqlSessionFactory 객체 생성
        InputStream inputStream = Resources.getResourceAsStream("bitcamp/java106/pms/sql/mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        objMap.put("SqlSessionFactory", factory);
        

        // 이전에 미리 준비했던 객체를 컨테이너에 포함시킴.
        iocContainer = new ApplicationContext("bitcamp.java106.pms", objMap);*/
        
        // 스프링 IoC 컨테이너 객체 생성
        // 설정을 지정했던 config 클래스를 인자로 준다.
        // 파라미터로 넘기는 값은 기타 설정작업을 수행하는 클래스 정보.
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
        
    }
    
    @Override
    public String execute(String requestURI) {
        // 클라이언트가 보낸 데이터에서 명령어와 데이터를 분리하여 객체를 준비한다.
        // requestURI의 형식 : 예) /board/add?title=aaa&content=bbb
        // serverRequest에서 상세한 명령어와 데이터들을 분리한다.
        try {
            ServerRequest request = new ServerRequest(requestURI);
            
            // 클라이언트 응답과 관련된 객체를 준비한다.
            StringWriter memWriter = new StringWriter();
            PrintWriter out = new PrintWriter(memWriter);
            
            ServerResponse response = new ServerResponse(out);
            
            // 클라이언트가 보낸 명령어를 처리할 컨트롤러를 찾는다.
            String path = request.getServerPath();
            Controller controller = (Controller) iocContainer.getBean(path);
            
            if (controller != null)
                controller.service(request, response);
            else
                out.println("해당 명령을 처리할 수 없습니다.");
            
            return memWriter.toString();
        } catch(Exception e) {
            return "error";
        }
    }
}
