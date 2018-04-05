package step16;

import java.io.File;
// 파일 생성
public class Exam04_1 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp2/a/test.txt"); 
        
        if(dir.createNewFile())
            System.out.println("파일 생성");
        else
            System.out.println("생성 불가");
        // 파일이 이미 있는 경우 생성 불가
        // 해당 경로의 디렉토리가 없어도 생성불가
    }
}
