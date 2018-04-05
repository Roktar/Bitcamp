package step16;

import java.io.File;

public class Exam03_1 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp"); // 생설할 디렉토리의 경로 설정
        
        if(dir.mkdir())
            System.out.println("디렉토리 생성");
        else
            System.out.println("생성 불가");
    }
}
