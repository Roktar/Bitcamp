package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_3 {
    
    // non-static nested Class(inner class) 사용의 예
    // 인스턴스가 있어야만 사용이 가능하다.
    class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            if(name.endsWith(".java"))
                return true;
            return false;
        }
    }
    
    public void test() {
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        // static nested class의 인스턴스 생성
        
        String[] names = dir.list(javaFilter);
        
        for(String name : names)
            System.out.println(name);
    }

    
    public static void main(String[] args) {
        Exam01_3 obj = new Exam01_3(); // JavaFilter 클래스 정보를 넘긴다.
        obj.test(); // JavaFilter 클래스의 인스턴스를 생성하는 코드가 있따.
    }
}
