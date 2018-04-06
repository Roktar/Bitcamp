package step19.ex1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ApplicationContext {
    private List<File> list = new ArrayList<>();

    public ApplicationContext(File dir) {
        findFiles(dir);
    }
    
    private void findFiles(File dir) {
        File[] files = dir.listFiles(); 
        
        for(File f : files)
            this.list.add(f);
    }
    
    public List<File> getFiles() { // 이 방법은 리스트의 주소를 넘겨주는 것이라 조작이 될 수 있음.
        return this.list;
    }
}
