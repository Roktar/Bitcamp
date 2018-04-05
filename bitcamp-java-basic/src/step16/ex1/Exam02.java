package step16;

import java.io.File;

// 파일 정보조회
public class Exam02 {
    public static void main(String[] args) throws Exception {
        File curDir = new File("./src/step16/Exam01.java");
        File parDir = new File("./src/step16/ok.java");
        
        System.out.printf("파일명 : %s\n", curDir.getName() );
        System.out.printf("파일크기 : %s\n", curDir.length() );
        System.out.printf("경로 : %s\n", curDir.getPath() );
        System.out.printf("계산된 절대경로 : %s\n", curDir.getCanonicalPath() );
        System.out.printf("절대경로 : %s\n", curDir.getAbsolutePath() );
        System.out.printf("총크기 : %s\n", curDir.getTotalSpace() );
        System.out.printf("가용크기 : %s\n", curDir.getUsableSpace() );
        System.out.printf("남은크기 : %s\n", curDir.getFreeSpace() );
        System.out.printf("디렉토리 여부 : %b\n", curDir.isDirectory() );
        System.out.printf("파일 여부 : %b\n", curDir.isFile() );
        System.out.printf("숨김 여부 : %b\n", curDir.isHidden() );
        System.out.printf("존재 여부 : %b\n", curDir.exists() );

        System.out.println("----------------------------------------------------");
        System.out.printf("파일명 : %s\n", parDir.getName() );
        System.out.printf("파일크기 : %s\n", parDir.length() );
        System.out.printf("경로 : %s\n", parDir.getPath() );
        System.out.printf("계산된 절대경로 : %s\n", parDir.getCanonicalPath() );
        System.out.printf("절대경로 : %s\n", parDir.getAbsolutePath() );
        System.out.printf("총크기 : %s\n", parDir.getTotalSpace() );
        System.out.printf("가용크기 : %s\n", parDir.getUsableSpace() );
        System.out.printf("남은크기 : %s\n", parDir.getFreeSpace() );
        System.out.printf("디렉토리 여부 : %b\n", parDir.isDirectory() );
        System.out.printf("파일 여부 : %b\n", parDir.isFile() );
        System.out.printf("숨김 여부 : %b\n", parDir.isHidden() );
        System.out.printf("존재 여부 : %b\n", parDir.exists() );
    }
}
