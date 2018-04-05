package step18.ex3;

import java.lang.reflect.Method;

// 메소드 정보 추출
public class Exam02 {
    
    public static void m1() {}
    public void m2() {}
    protected void m3() {}
    void m4() {}
    private void m5() {}
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Class clazz = Exam01.class;
        
        // 모든 메소드 추출(단, 상속받은 메소드 제외)
        Method[] list = clazz.getDeclaredMethods();
        
        for(Method m : list)
            System.out.println(m.getName());
    }
}
