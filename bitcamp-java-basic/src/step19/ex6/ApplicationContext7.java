package step19.ex6;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// 클래스 이름으로 클래스를 로딩하여 클래스 객체 생성
public class ApplicationContext7 {
    private List<Object> list = new ArrayList<>();

    public ApplicationContext7(String pkgName) throws Exception {
        ClassLoader cLoader = ClassLoader.getSystemClassLoader();
        URL url = cLoader.getResource(pkgName.replace(".", "/"));
        if(url == null)
            return;
        File dir = new File(url.getPath());
        
        if(!dir.isDirectory())
            return;
        findClasses(new File(url.getPath()), pkgName);
    }
    // pkgName은 상위 폴더명이다. (step19 혹은 step19/ex1 같은)
    // 클래스로딩하려면 패키지명이 포함된 클래스 이름이 잇어야하기때문에
    // 패키지명으로 시작한다./
    
    private void findClasses(File dir, String pkgName) throws Exception {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                
                if(pathname.isDirectory() ||
                    (pathname.getName().endsWith(".class") && 
                     !pathname.getName().contains("$")))
                    return true;
                return false;
            }
        }); 
        
        // 재귀로 들어가는 경우 :
        // 1) pkgName = step19, 파일이 아니므로 재귀 => pkgName.현재폴더이름 : step19.ex1
        // 2) pkgName = step19.ex1, 파일이므로 추가한다. => pkgName.현재파일이름 : step19.ex1.Exam01.class
        //    하지만 .class는 제거할 것이기때문에 문자열을 추출해서 .class를 제거하고 붙인다.
        //    즉, 저장되는 건 step19.ex1.Exam01이 될 것이다.
        
        for(File f : files) {
            if(f.isDirectory()) { // 디렉토리인 경우 파일을 찾는다
                findClasses(f, pkgName + "." + f.getName());
                continue;
            }
            
            String classname = f.getName();
            Class clazz = Class.forName(pkgName + "." + classname.substring(0, classname.length() -6));
            Object obj = createObject(clazz);
            
            if(obj != null)
                list.add( obj );
            // 클래스 객체가 아닌 그 클래스 객체를 이용한 인스턴스를 만들어 저장한다.
        }     
    }
    
    private Object createObject(Class clazz) throws Exception {
        
        try {
        // 매개변수가 없는 기본 생성자를 찾는다.
        // 만약 기본생성자가 없는 경우, 보통은 null은 반환하지만 이것은 null을 반환하지않는다.
        // 못찾는 경우 반환되는 건 그냥 에러다.
            clazz.getConstructor(); // 생성자가 있는 지 없는 지 우선 호출해본다.
                                    // 만약 없으면 catch문에 잡힐 것이다.
            return clazz.newInstance();
        } catch (Exception e) {
            return null;
        } // 예외처리

    }
    
    public List<Object> getObjects() {
        return this.list;
    }
}
