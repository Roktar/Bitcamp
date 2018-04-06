package step18.ex7;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;

// 특정 패키지의 특정 파일 형식의 목록을 알아내기(여기서는 .class파일)
public class Exam03 {
    public static void main(String[] args) throws Exception {
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        // JVM은 이미 클래스패스를 알고있기때문에 클래스패스/패키지명으로 구성되는
        // 현재 시스템에서는 패키지명에 해당하는 폴더와 파일의 이름을 주면
        // 절대 경로를 찾을 수 있다.
        URL url = cLoader.getResource("step18/ex6");
        
        File file = new File(url.getPath());
        File[] fileList = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // TODO Auto-generated method stub
                if(name.endsWith(".class") && !name.contains("$") )
                    return true;
                
                return false;
            } // $가 붙은 것은 내부클래스고, 이 인터페이스는 여기서의 익명클래스이자 내부클래스다.
        });
        
        for(File f : fileList)
            System.out.println(f.getCanonicalPath());

    }
}
