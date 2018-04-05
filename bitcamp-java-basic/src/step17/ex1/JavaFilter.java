package step17.ex1;

import java.io.File;
import java.io.FilenameFilter;

// 다음 클래스처럼 패키지에 직접 소속되는 클래스를 "패키지 멤버 클래스"라고 부름.
public class JavaFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        if(name.endsWith(".java"))
            return true;
        return false;
    }
}
