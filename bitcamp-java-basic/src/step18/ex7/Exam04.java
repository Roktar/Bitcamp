package step18.ex7;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// 특정 패키지와 그 하위 패키지에서 특정 파일 형식의 목록을 알아내기(여기서는 .class파일)
public class Exam04 {
    public static void main(String[] args) throws Exception {
        // 클래스로더 객체 받아오기 -> URL 객체에 리소스 요청하면서 패키지명 제공
        // -> 파일로 만들기 -> 파일로부터 꺼내기
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        URL url = cLoader.getResource("step18");
        
        List<File> files = findClasses(new File(url.getPath()));
        
        for(File f : files)
            System.out.println(f.getCanonicalPath());

    }
    
    static ArrayList<File> findClasses(File dir) throws Exception { // 별도 메소드로 분리
        File file = new File(dir.getPath());
        File[] files = file.listFiles(new FileFilter() { // 여기서 하위 폴더, 혹은 파일의 정보를 분리한다.
            
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory() || pathname.getName().endsWith(".class") && !pathname.getName().contains("$"))
                    return true;
                return false;
            } // 디렉토리인 경우 그냥 패스
              // 디렉토리가 아닌 경우 파일 이름을 비교하고 맞으면 패스, 아니면 논패스.
              // File 안에는 directory인 지, file인 지에 대한 정보가 있다는 걸 잊었네.
        });
        
       ArrayList<File> list = new ArrayList<>();
       
       for(File f : files) {
           if(f.isDirectory())
               list.addAll(findClasses(f));
           else
               list.add(f);
       }
        
        return list;
    }
}
