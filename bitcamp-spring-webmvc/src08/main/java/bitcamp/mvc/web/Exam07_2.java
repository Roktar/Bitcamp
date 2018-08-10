// 경로 변수
package bitcamp.mvc.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller 
@RequestMapping("/exam07_2") 
public class Exam07_2 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(String name, int age) {
        return String.format("m1: name=%s, age=%d", name, age);
    }
    
    @GetMapping(value="m2/{value}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(@PathVariable String value, @MatrixVariable String name, @MatrixVariable int age, @MatrixVariable String tel) {
        return String.format("m2: %s, %s, %d, %s", value, name, age, tel);
    }
    // value는 value칸이 비워졌을 경우 m2/ 다음에 오는 모든 값이 value가 된다.
    // 즉, name=...;age=...;tel=...; 이 value가 된다.
    // 단, value에 값이 주어졌을 경우, valye는 그 값이 된다.
    // ex) http://localhost:8888/java106-spring-webmvc/mvc/exam07_2/m2/test;name=aaa;age=20;tel=1111-2222

    
    // 컨테이너 얻기
    
    // ServletContext 얻기 - 페이지 컨텍스트에서부터 주입받는다.
    @Autowired ServletContext sc;
    
    // 프론트 컨트롤러부터 ServletContext 얻기
    @Autowired ApplicationContext appCtx;

    @GetMapping(value="test", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String test() {
        StringBuffer buf = new StringBuffer();
        
        // ContextLoaderListener가 관리하는 Spring IoC Container 얻기
        ApplicationContext rootCtx = WebApplicationContextUtils.getWebApplicationContext(sc);
        String[] names = rootCtx.getBeanDefinitionNames();
        for(String name : names)
            buf.append(rootCtx.getBean(name).toString() + "\n");
        buf.append("----------------------------------------------------------------------");
        
        // 프론트 컨트롤러가 관리하는 Spring IoC Container 얻기
        names = appCtx.getBeanDefinitionNames();
        for(String name : names)
            buf.append(appCtx.getBean(name).toString() + "\n");
        
        return buf.toString();
    }
    
    // 같은 이름으로 파라미터를 받아올 때 ex) exam07_2/m3/{name}/{name}
    // http://localhost:8888/java106-spring-webmvc/mvc/exam07_2/m3/name=%ED%8C%801;qty=7/name=%EC%9E%91%EC%97%85100;state=1
    @GetMapping(value="m3/{team}/{task}", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(@MatrixVariable(name="name", pathVar="team") String name1, @MatrixVariable(name="name", pathVar="task") String name2) {
        return String.format("m3:팀명=%s, 작업명=%s", name1, name2);
    }
}

