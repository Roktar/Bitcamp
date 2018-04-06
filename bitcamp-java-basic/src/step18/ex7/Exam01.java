package step18.ex7;

import java.net.URL;
import java.util.Enumeration;

// 자바 classpath에서 특정 패키지에 들어있는 자원들을 알아내기
public class Exam01 {
    public static void main(String[] args) throws Exception {
        // 1) 클래스패스를 뒤져서 파일을 찾아줄 객체를 얻기
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        // 2) 클래스로더는 디렉토리나 ㅍ ㅏ일을 찾을 때, JVM에 지정된 클래스패스를 찾아본다
        //    자원이 있는 경로를 지정할 때는 .대신 /를 사용할 것.
        //    클래스로더는 클래스패스를 알고있다
        // 아래는 cㄹ부터 시작되는 폴더부터 찾는 경로까지의 주소를 모두 포함하여ㅑ 반환한다.
        URL resource = cLoader.getResource("step18/ex6/test.txt");
        Enumeration<URL> resources = cLoader.getResources("step18/ex6");
        // getResources가 리턴하는 것 : 찾은 자원의 경로 정보
        while(resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url.getPath());
            System.out.println(url.getFile());
        }
        
        System.out.println(resource.getPath());
        
        // 사용이유
        // - 파일의 실제 위치를 알고 싶을 때 : 아니면 직접 하드하게 주소를 찾아봐야함.
        
        // 같은 경로의 자원이 여러 디렉토리에 중복해서 있을 때는
        // getResources() 함수를 통해 여러개의 경로 정보를 받을 것.
        // Run configration - class path - advance에서 폴더 추가
        
        // getPath : 절대경로
        // getFile : getPath + Query
        
        
        
    }
}
