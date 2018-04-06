package step19.ex2;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext3 {
    private List<File> list = new ArrayList<>();

    public ApplicationContext3(String pkgName) throws Exception {
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
        File[] files = dir.listFiles(); 
        
        for(File f : files) {
            if(f.isDirectory())
                findFiles(f);
            else
                list.add(f);
        }
    }
    
    public List<File> getFiles() {
        return this.list;
    }
}
