package step19.ex1;

import java.io.File;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 1) 특정 패키지의 파일 목록 알아내기

// 파일 및 디렉토리 정보를 알아내는 코드를 별도의 메소드로 분리
public class Exam02 {
    public static void main(String[] args) {
        // 패키지 경로 준비
        File packageDir = new File("C:\\Users\\Bit\\git\\Bitcamp\\bitcamp-java-basic\\src\\step19\\ex1");
        // 해당 디렉토리에서 파일 목록 가져오기
        //ArrayList<File> files = findFiles(packageDir); // ArrayList로 데이터를 받음
        //Vector<File> files = findFiles(packageDir); // Vector로 데이터를 받음
        List<File> files = findFiles(packageDir); // List로 구현체를 받음
        
        for(File f : files) {
            if(f.isDirectory())
                System.out.printf("d %s\n", f.getName());
            else
                System.out.printf("- %s\n", f.getName());
        }
        
    }
    // arraylist
/*    static ArrayList<File> findFiles(File dir) {
        ArrayList<File> list = new ArrayList<>();
        File[] files = dir.listFiles(); // string에서 listFiles를 쓰는 게 아님.
                                        // 이미 경로 주소는 이 File 객체에 들어있다.
        
        for(File f : files)
            list.add(f);
        
        return list;
    }*/
    
    // vector
/*    static Vector<File> findFiles(File dir) {
        Vector<File> list = new Vector<>();
        File[] files = dir.listFiles(); 
        
        for(File f : files)
            list.add(f);
        
        return list;
    }*/
    
    // List 인터페이스에 List 규칙을 따른 구현체를 반환
    static List<File> findFiles(File dir) {
        List<File> list = new Vector<>();
        File[] files = dir.listFiles(); 
        
        for(File f : files)
            list.add(f);
        
        return list;
    }
    
    
}
