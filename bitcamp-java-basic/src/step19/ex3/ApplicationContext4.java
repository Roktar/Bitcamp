package step19.ex3;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext4 {
    private List<File> list = new ArrayList<>();

    public ApplicationContext4(String pkgName) throws Exception {
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
        findFiles(new File(url.getPath()));
    }
    
    private void findFiles(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                
                if(pathname.isDirectory() ||
                    (pathname.getName().endsWith(".class") && 
                     !pathname.getName().contains("$")))
                    return true;
                // 디렉토리거나 .class파일인 경우(단 내부클래스 제외) 리스트에 포함
                return false;
            }
        }); 
        
        for(File f : files)
            list.add(f);
    }
    
    public List<File> getFiles() {
        return this.list;
    }
}
