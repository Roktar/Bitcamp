package step18.ex5;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Exam01 {
    public void m1(String name, int age) {}
    public void m2() {}
    public void m3(File file, String name) {}
    
    
    public static void main(String[] args) {
        Class clazz = Exam01.class;
        
        Method[] methods = clazz.getDeclaredMethods();
        
        for(Method m : methods) {
            System.out.printf( "%s - ", m.getName() );
            
            Parameter[] parameters = m.getParameters();
            
            for(Parameter p : parameters) 
                System.out.printf("%s:%s\n", p.getName(), p.getType().getName());
            // 파라미터의 이름은 argx 형태로 되어있고
            // class파일에는 분명히 파라미터 이름이 보관되어있다.
            // 하지만 리플렉션 api에서는 보관된 값을 꺼낼 수 없다.
            
            // 파라미터 이름을 리플렉션 api에서 꺼낼 수 있도록 설정 : -parameters를 붙인다.
        }
    }
}
