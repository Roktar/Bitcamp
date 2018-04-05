package step16;

import java.io.File;
// 디렉토리 제거
public class Exam03_3 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp"); // 생설할 디렉토리의 경로 설정
        
        // temp2의 디렉토르가 존재하지않을 때, a는 만들 수 없다.
        if(dir.delete())
            System.out.println("디렉토리 삭제");
        else
            System.out.println("삭제 불가");
    }
}
