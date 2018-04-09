package step20.ex5;

public class Exam05 {
    public static void main(String[] args) {
        Class clazz = MyClass5.class;
        
        MyAnnotation3 obj = (MyAnnotation3) clazz.getAnnotation(MyAnnotation3.class);

        System.out.println(obj.v1()[0]);
        System.out.println(obj.v2()[0]);
        System.out.println(obj.v3()[0]);
        
        for(String s : obj.v1())
            System.out.println(s);        
        for(int i : obj.v2())
            System.out.println(i);        
        for(float f : obj.v3())
            System.out.println(f);
    }
}
