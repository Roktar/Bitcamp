package step16;

import java.io.File;
// 파일 생성
public class Exam04_3 {
    public static void main(String[] args) throws Exception {
        File file = new File("temp/a/test.txt"); 
        
        //File dir = new File( file.getParent() );
        File dir = file.getParentFile();
        
        if(dir.mkdirs())
            System.out.println("디렉토리 생성");
        else
            System.out.println("생성 불가");
        
        if(file.createNewFile())
            System.out.println("파일 생성");
        else
            System.out.println("생성 불가");
        // 파일이 이미 있는 경우 생성 불가
        // 해당 경로의 디렉토리가 없어도 생성불가
    }
}
