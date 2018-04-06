package step18.ex7;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {
    public List<Class> classes;
    
    public ApplicationContext(String name) throws Exception {
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        // 클래스 로더 준비
        URL url = cLoader.getResource(name.replace('.', '/'));
        // 패키지 이름으로 실제 경로를 찾을 때, 패키지를 구분하는 구분자인 .을
        // 경로구분자인 /로 대체한다.
        classes = findClasses(new File(url.getPath()), name);
    }
    
    private List<Class> findClasses(File dir, String pacName) throws Exception { // 별도 메소드로 분리
        File[] files = dir.listFiles(new FileFilter() { // 여기서 하위 폴더, 혹은 파일의 정보를 분리한다.
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory() || pathname.getName().endsWith(".class") && !pathname.getName().contains("$"))
                    return true;
                return false;
            } // 디렉토리인 경우 그냥 패스
              // 디렉토리가 아닌 경우 파일 이름을 비교하고 맞으면 패스, 아니면 논패스.
              // File 안에는 directory인 지, file인 지에 대한 정보가 있다.
        });
        
       ArrayList<Class> list = new ArrayList<>();
       
       for(File f : files) {
           if(f.isDirectory())
              list.addAll(findClasses(f, pacName + "." + f.getName()));
           else {
               String classname = pacName + "." + f.getName();
               // classname 완성본 예 : step18.ex.Aaa.class
               // 전체 문자열 길이를 구하는 함수 : length()
               // 여기서는 .class를 제거하고 표시할 것이다.
               // 전체 문자열 길이 - ".class", 즉 6
               // .class를 뺀 길이만 구하면 되는 것이니 6을 뺀다.
               // .class를 제거하ㅣ지않는다면 -6을 쓸 필요가 없다.

               list.add(Class.forName(classname.substring(0, classname.length() -6)));
           }
       }
        
        return list;
    }
}
