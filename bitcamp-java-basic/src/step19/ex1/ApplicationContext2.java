package step19.ex1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ApplicationContext2 {
    private List<File> list = new ArrayList<>();

    public ApplicationContext2(File dir) {
        findFiles(dir);
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
