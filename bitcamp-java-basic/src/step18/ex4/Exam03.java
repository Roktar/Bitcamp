package step18.ex4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 생성자 호출
public class Exam03 {
    int value;
    
    public Exam03(int i) {
        this.value = i;
    }
    
    public void print() {
        System.out.printf("value=%d\n", this.value);
    }
    
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class clazz = Exam03.class;
        
        //Exam03 obj = (Exam03) clazz.newInstance(); // 기본 생성자가 없어서 에러
        // 해결방법
        // 1. 생성자를 준비한다.
        Constructor c = clazz.getConstructor(int.class);
        // 2. 생성자 객체를 통해 인스턴스를 생성한다.
        Exam03 obj = (Exam03) c.newInstance(200);
        obj.print();
    }
}
