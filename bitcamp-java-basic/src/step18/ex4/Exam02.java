package step18.ex4;

import java.lang.reflect.Constructor;

// 생성자 정보 추출 - 조건에 주어진 데이터타입을 인수로 갖는 생성자 추출
public class Exam02 {
    public Exam02() {}
    public Exam02(int i) {}
    public Exam02(String s, int i) {}
    
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Class clazz = Exam01.class;
        
        Constructor list = clazz.getConstructor(int.class);
        
        System.out.printf("%s(%d)\n", list.getName(), list.getParameterCount());
        
        // getParametercount는 매개변수의 갯수를 반환한다.
    }
}
