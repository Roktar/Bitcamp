package step18.ex1;

public class Exam03 {
    static class A {
        static int s_var;
        int i_var;
        
        static void s_m() {}
        void i_m() {}
        
        static {
            System.out.println("클래스 로딩");
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = A.class;
        // 자바의 모든 클래스는 "class"라는 스태틱 변수를 가지고 있다.(클래스명.class)
        // "class"변수에는 해당 클래스의 정보를 담은 Class 객체의 주소가 저장되어 있다.
        // class 변수의 반환은 Class 타입인가보다.
        // 정보를 받아들이지만 실제 할당은 아직 이뤄지지않는가봄.
                
    }
}
