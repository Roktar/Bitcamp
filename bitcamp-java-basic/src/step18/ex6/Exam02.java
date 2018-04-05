package step18.ex6;

import java.io.File;
import java.net.URL;

// 특정 패키지의 파일 목록을 알아내기
public class Exam02 {
    public static void main(String[] args) throws Exception {
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        // JVM은 이미 클래스패스를 알고있기때문에 클래스패스/패키지명으로 구성되는
        // 현재 시스템에서는 패키지명에 해당하는 폴더와 파일의 이름을 주면
        // 절대 경로를 찾을 수 있다.
        URL url = cLoader.getResource("step18/ex6");
        
        File file = new File(url.getPath());
        File[] fileList = file.listFiles();
        
        for(File f : fileList)
            System.out.println(f.getCanonicalPath());
        // canonical은 절대경로 그대로 표기
        // getName은 파일 이름만 갖고온다.
        
    }
}
