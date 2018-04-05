package step18.ex3;

import java.lang.reflect.Method;

// 메소드 정보 추출
public class Exam03 {
    
    public static void m1() {}
    public void m2() {}
    protected void m3() {}
    void m4() {}
    private void m5() {}
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Class clazz = Exam01.class;
        
        // 인자없는 메소드 추출(단, public으로 지정된 메소드만)
        Method list = clazz.getMethod("m1");
        // Method list = clazz.getMethod("m3"); // public이 아니라서 Exception 발생
        System.out.println(list.getName());
        System.out.println(clazz.getMethod("toString").getName() );
        // 상속받은 메소드도 찾는다.
        
        // 아래는 public이 아니어도 메소드를 추출, 상속받은 메소드는 찾지못함.
        Method m = clazz.getDeclaredMethod("m3");
        System.out.println(m.getName());
        System.out.println(clazz.getDeclaredMethod("toString").getName() );

    }
}
