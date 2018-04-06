package step19.ex1;

import java.io.File;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 1) 특정 패키지의 파일 목록 알아내기

// 파일 및 디렉토리 정보를 알아내는 코드를 별도의 클래스로 분리(ApplicationContext)
public class Exam03 {
    public static void main(String[] args) {
        // 패키지 경로 준비
        File packageDir = new File("C:\\Users\\Bit\\git\\Bitcamp\\bitcamp-java-basic\\src\\step19\\ex1");
        ApplicationContext appContext = new ApplicationContext(packageDir);
        
        List<File> files = appContext.getFiles(); // List로 구현체를 받음
        
        for(File f : files) {
            if(f.isDirectory())
                System.out.printf("d %s\n", f.getName());
            else
                System.out.printf("- %s\n", f.getName());
        }
        
    }
       
}
