package step19.ex4;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 4) 파일 경로 대신 패키지 이름을 포함한 클래스 이름을 추출



public class Exam07 {
    public static void main(String[] args) throws Exception {

        ApplicationContext5 appContext = new ApplicationContext5("step19");
        
        List<String> classnames = appContext.getFiles(); // List로 구현체를 받음
        
        for(String f : classnames) 
                System.out.printf("%s\n", f);
        
    }
}
