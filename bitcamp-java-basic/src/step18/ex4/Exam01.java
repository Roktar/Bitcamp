package step18.ex4;

import java.lang.reflect.Constructor;

// 생성자 정보 추출
public class Exam01 {
    public Exam01() {}
    public Exam01(int i) {}
    public Exam01(String s, int i) {}
    
    public static void main(String[] args) {
        Class clazz = Exam01.class;
        
        Constructor[] list = clazz.getConstructors();
        
        for(Constructor c : list)
            System.out.printf("%s(%d)\n", c.getName(), c.getParameterCount());
        
        // getParametercount는 매개변수의 갯수를 반환한다.
    }
}
