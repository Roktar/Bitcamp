package step19.ex4;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext5 {
    private List<String> list = new ArrayList<>();

    public ApplicationContext5(String pkgName) throws Exception {
        // 1) 클래스 로더 준비
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        
        // 2) 클래스로더로부터 경로를 가지고온다.
        URL url = cLoader.getResource(pkgName.replace(".", "/"));
        // URL은 클래스로더로부터 갖고온다. 이건 좀 헷갈리네
        
        // 3) URL에서 실제 경로를 뽑아 File 객체를 생성
        if(url == null)
            return;
        File dir = new File(url.getPath());
        
        // 4) 해당 파일의 경로가 디렉토리를 가리키고있다면, 그 디렉토리의 파일 목록을 알아내기
        if(!dir.isDirectory())
            return;
        findFiles(new File(url.getPath()), pkgName);
    }
    
    // 파일 경로에서 패키지명과 클래스명을 추출할 수 없기때문에 패키지이름을 따로 관리한다.
    private void findFiles(File dir, String pkgName) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                
                if(pathname.isDirectory() ||
                    (pathname.getName().endsWith(".class") && 
                     !pathname.getName().contains("$")))
                    return true;
                return false;
            }
        }); 
        
        for(File f : files) {
            if(f.isDirectory())
                findFiles(f, pkgName + "." + f.getName());
            else {
                String classname = f.getName();
                list.add(pkgName + "." + classname.substring(0, classname.length() -6));
            }
        }
    }
    
    public List<String> getFiles() {
        return this.list;
    }
}
