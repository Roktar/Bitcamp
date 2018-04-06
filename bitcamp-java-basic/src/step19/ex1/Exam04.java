package step19.ex1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 1) 특정 패키지의 파일 목록 알아내기

// 지정된 디렉토리뿐만이 아닌 하위 디렉토리도 검색하여 파일 목록을 알아내기.
public class Exam04 {
    public static void main(String[] args) throws IOException {
        // 패키지 경로 준비
        File packageDir = new File("\\C:\\Users\\Bit\\git\\Bitcamp\\bitcamp-java-basic\\src\\step19");
        ApplicationContext2 appContext = new ApplicationContext2(packageDir);
        
        List<File> files = appContext.getFiles(); // List로 구현체를 받음
        
        for(File f : files)
                System.out.printf("%s\n", f.getCanonicalPath());
        
    }
       
}
