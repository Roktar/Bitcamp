package step16;

import java.io.File;
// 파일 생성
public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp2/a/test.txt"); 
        
        if(dir.delete())
            System.out.println("파일 삭제");
        else
            System.out.println("삭제 불가");
        // 파일이 이미 있는 경우 생성 불가
    }
}
