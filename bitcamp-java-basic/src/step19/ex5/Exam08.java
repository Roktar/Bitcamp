package step19.ex5;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 5) 클래스 이름으로 클래스 객체를 만들기


// 클래스 이름으로 해당 클래스를 로딩한 후, 클래스 객체를 가지고온다.
// 클래스 객체가 있으면 언제든지 인스턴스를 생성할 수 있다!
public class Exam08 {
    public static void main(String[] args) throws Exception {

        ApplicationContext6 appContext = new ApplicationContext6("step19");
        
        List<Class> classes = appContext.getFiles(); // List로 구현체를 받음
        
        for(Class f : classes) 
                System.out.printf("%s\n", f.getName());
    }
}
