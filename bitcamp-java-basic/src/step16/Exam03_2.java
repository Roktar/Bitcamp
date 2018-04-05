package step16;

import java.io.File;

public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp2/a"); // 생설할 디렉토리의 경로 설정
        
        
        // temp2의 디렉토르가 존재하지않을 때, a는 만들 수 없다.
        if(dir.mkdir())
            System.out.println("디렉토리 생성");
        else
            System.out.println("생성 불가");
        
        if(dir.mkdirs())
            System.out.println("디렉토리 생성");
        else
            System.out.println("생성 불가");
    }
}
