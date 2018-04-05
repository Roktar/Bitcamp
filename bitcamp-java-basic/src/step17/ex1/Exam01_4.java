package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_4 {
    
    public static void main(String[] args) {
        
        // local class 사용의 예
        // 특정 메소드 안에서만 사용하는 클래스.
        class JavaFilter implements FilenameFilter {
            public boolean accept(File dir, String name) {
                if(name.endsWith(".java"))
                    return true;
                return false;
            }
        }
        
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        
        String[] names = dir.list(javaFilter);
        
        for(String name : names)
            System.out.println(name);
    }
}
