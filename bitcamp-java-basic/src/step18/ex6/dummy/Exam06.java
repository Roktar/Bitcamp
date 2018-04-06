package step18.ex6;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// 특정 패키지와 그 하위 패키지에서 특정 파일 형식의 목록을 알아내기(여기서는 .class파일)
public class Exam06 {
    public static void main(String[] args) throws Exception {
        
        ApplicationContext appContext = new ApplicationContext("step18");
        List<Class> classes = appContext.classes;
        
        for(Class clazz : classes)
            System.out.println(clazz.getName());
    }
}
