package step18.ex5;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

// 메소드의 반환형 가져오기
public class Exam02 {
    public String m1(String name, int age) { return null; }
    public char[] m2() {return null;}
    public ArrayList m3(File file, String name) {return null;}
    
    
    public static void main(String[] args) {
        Class clazz = Exam01.class;
        
        Method[] methods = clazz.getDeclaredMethods();
        
        for(Method m : methods) {
            System.out.printf( "%s - ", m.getName() );
            
            Class returnType = m.getReturnType();
            
            System.out.printf("%s\n", returnType.getName());
        }
    }
}
