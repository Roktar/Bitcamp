package step16;

// 확장자가 .java인 파일의 이름만 추출하기

import java.io.File;
import java.io.FilenameFilter;
// 파일 생성
public class Exam06_1 {
    static class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            if(name.endsWith(".java"))
                return true;
            return false;
        }
        // boolean 값에 따라 true면 결과에 포함, false면 결과에 포함하지않는다.
        // 즉, 여기서의 boolean값은 반환되는 값이 아니라 그저 반환되는 데에 쓰는 값일 뿐이다.
        // 반환되는 값은 여기선 안보이지만 다른 곳에 있다.
    }
    
    public static void main(String[] args) throws Exception {
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        //String[] names = dir.list(javaFilter);
        String[] names = dir.list(new FilenameFilter() {
            
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".java"))
                    return true;
                return false;
            }
        });
        // 파일이름을 반환한다. (xxx.a 처럼 확장자를 포함한 이름)
        // caller : File
        // callee : Filter, Filter는 인터페이스다.
        
        for(String name : names)
                System.out.println(name);
    }
}
