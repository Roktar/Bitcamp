package step18.ex3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exam05 {
    public static void plus(int a, int b) {
        System.out.printf("합계 : %d", (a+b));
    } // static method
    
    public void minus(int a, int b) {
        System.out.printf("감산 : %d", (a-b));
    } // non-static method
    
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 메소드를 불러오는데 메소드가 어떤 클래스에 있는 지에 대한 정보가 필요하다
        // 그래서 클래스 정보를 가져온다.
        Class clazz = Exam05.class;
        
        // 클래스 정보로부터 해당 메소드를 찾아서 그 메소드의 정보를 가지고온다.
        Method m = clazz.getMethod("plus", int.class, int.class);
        
        // 메소드 호출 : invoke(인스턴스, args..)
        // static 메소드는 인스턴스를 줄 필요가 없다.
        m.invoke(null, 10, 20);
        
        //인스턴스 메소드를 찾아서 메소드의 정보를 가지고온다.
        Method m2 = clazz.getMethod("minus", int.class, int.class);
        
        // minus는 인스턴스 메소드기때문에 인스턴스를 넘겨줘야한다.
        // 넘겨주기위해 우선 인스턴스를 만든다.
        // 그 후 그 인스턴스를 넘겨주고 호출한다.
        Exam05 obj = new Exam05();
        m2.invoke(obj, 20, 20);
        
    }
}
