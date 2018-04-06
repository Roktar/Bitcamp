package step19.ex5;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// 클래스 이름으로 클래스를 로딩하여 클래스 객체 생성
public class ApplicationContext6 {
    private List<Class> list = new ArrayList<>();

    public ApplicationContext6(String pkgName) throws Exception {
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        URL url = cLoader.getResource(pkgName.replace(".", "/"));
        if(url == null)
            return;
        File dir = new File(url.getPath());
        
        if(!dir.isDirectory())
            return;
        findFiles(new File(url.getPath()), pkgName);
    }
    
    private void findFiles(File dir, String pkgName) throws Exception {
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
                list.add( Class.forName(pkgName + "." + classname.substring(0, classname.length() -6)));
            } // 이름을 저장하는 게 아닌 이름을 가지고 클래스를 로딩한 후 그 객체를 리스트에 저장
        }     // 패키지명과 클래스명이면 클래스를 로딩할 수 있다!
    }
    
    public List<Class> getFiles() {
        return this.list;
    }
}
