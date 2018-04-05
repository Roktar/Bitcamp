package step16;

import java.io.File;
// 파일 생성
public class Exam05_2 {
    public static void main(String[] args) throws Exception {
        File dir = new File("."); 
        
        // file 객체로 받아서 내부 함수를 통해 디렉토리인지 아닌지 찾아보기
        File[] names = dir.listFiles();
        
        for(File file : names)
            System.out.printf("%s %12d %s\n", (file.isDirectory() ? "d" : "-"), file.length(), file.getName() );
    }
}
