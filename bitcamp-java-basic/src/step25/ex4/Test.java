package step25.ex4;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class Test {
    
    public static void main(String[] args) throws Exception {
        
        // 프로그램 아규먼트
        for(String arg : args) {
            System.out.println(arg);
        }
        
        // 시스템 아규먼트
        Properties jvmProps = System.getProperties();
        Set<Object> keySet = jvmProps.keySet();
        for(Object key : keySet)
            System.out.printf("%s=%s\n", key, jvmProps.get(key));
        
        // 프로퍼티 파일에서 읽어오기
        Properties fileProps = new Properties();
        fileProps.load(new FileInputStream("jdbc.properties") );
        keySet = fileProps.keySet();
        for(Object key : keySet)
            System.out.printf("%s=%s\n", key, fileProps.get(key));
    }
}
