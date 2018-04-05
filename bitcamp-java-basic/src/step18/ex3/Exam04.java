package step18.ex3;

import java.lang.reflect.Method;

// 특정 메소드에 매개변수도 추출
public class Exam04 {
    
    public void m1() {}
    public void m2(String s) {}
    public void m3(String s, int i) {}
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Class clazz = Exam04.class;
        // 파라미터가 없는 경우, 파라미터의 정보를 넘기지않는다.
        System.out.println(clazz.getMethod("m1").getName());
        // 파라미터가 있는 경우, 그 파라미터의 데이터타입에 대한 클래스의 정보를 넘긴다.
        System.out.println(clazz.getMethod("m2", String.class).getName());
        System.out.println(clazz.getMethod("m3", String.class, int.class).getName());
        //아래처럼 forName함수로 해당 클래스의 정보를 가져와서 클래스타입으로 넘겨줘도 된다.
        Class parameterType = Class.forName("java.lang.String");
        System.out.println(clazz.getMethod("m2", parameterType).getName());

        Class intType = int.class, stringType = String.class;
//        
//        m = clazz.getMethod("m3", intType, stringType);  // 에러 : 매개변수의 순서가 다르다.
        clazz.getMethod("m3", stringType, intType);
        
    }
}
