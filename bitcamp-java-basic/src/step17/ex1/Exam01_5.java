package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_5 {
    
    public static void main(String[] args) {
                
        File dir = new File(".");
                
        // anonymous class 사용의 예
        // 인스턴스를 여러 개 만들 필요가 없을 때 사용하는 클래스.
        String[] names = dir.list(new FilenameFilter() {// super클래스(Object)의 기본 생성자를 호출
            public boolean accept(File dir, String name) {
                if(name.endsWith(".java"))
                    return true;
                return false;
            }
        });
        
        for(String name : names)
            System.out.println(name);
    }
}
