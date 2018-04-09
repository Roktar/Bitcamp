package step20.ex2;

// Annotation 확인

@MyAnnotation("값")
@MyAnnotation2("값")
@MyAnnotation3("값")
public class Exam01 {
    public static void main(String[] args) {
        Class clazz = MyClass.class;
        // 클래스 정보 객체로부터 어노테이션 정보 추출
        // object형식으로 반환되므로 해당 어노테이션 형식으로 형변환해야한다.
        MyAnnotation obj = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        
        if(obj==null)
            System.out.println("MyAnnotation이 없다.");
        else
            System.out.println("MyAnnotation이 있다.");
        
        MyAnnotation2 obj2 = (MyAnnotation2) clazz.getAnnotation(MyAnnotation2.class);
        
        if(obj2==null)
            System.out.println("MyAnnotation2이 없다.");
        else
            System.out.println("MyAnnotation2이 있다.");
        
        MyAnnotation3 obj3 = (MyAnnotation3) clazz.getAnnotation(MyAnnotation3.class);
        
        if(obj3==null)
            System.out.println("MyAnnotation3이 없다.");
        else
            System.out.println("MyAnnotation3이 있다." + obj3.value());
        
    }
}
