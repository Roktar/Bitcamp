package step16;

// 디렉토리에 들어있는 파일이나 하위 디렉토리 정보 알아내기

import java.io.File;
// 파일 생성
public class Exam05_1 {
    public static void main(String[] args) throws Exception {
        File dir = new File("."); 
        
        String[] names = dir.list();
        
        for(String name : names)
            System.out.println(name);
    }
}
