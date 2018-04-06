package step19.ex3;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 1) 특정 패키지의 파일 목록 알아내기

// 디렉토리 경로 대신 패키지 이름을 입력받아서 목록을 알아내기.
// => 클래스 로더로 자바 클래스패스를 검색하여 해당 패키지를 찾는다.
public class Exam06 {
    public static void main(String[] args) throws Exception {
        // 패키지 경로를 따로 준비하지않는다.
        // 패키지명을 별도로 입력받아 사용할 수 있다.
        ApplicationContext4 appContext = new ApplicationContext4("step19.ex3");
        
        List<File> files = appContext.getFiles(); // List로 구현체를 받음
        
        for(File f : files)
                System.out.printf("%s\n", f.getName());
        
    }
}
