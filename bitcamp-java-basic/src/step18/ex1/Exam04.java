package step18.ex1;

class X {
    static {
        System.out.println("X 로딩");
    }
}

class Y {
    static {
        System.out.println("X 로딩");
    }
}

class Z {
    static {
        System.out.println("X 로딩");
    }
}

public class Exam04 {
    static class A {
        static int s_var;
        int i_var;
        
        static void s_m() {}
        void i_m() {}
        
        static {
            System.out.println("A 로딩");
        }
    }
    
    public static void main(String[] args) throws Exception {
        // forName()은 프로그램 아규먼트 혹은 키보드 입력을 통해 클래스 명을 입력받아 로딩 가능.
        Class.forName(args[0]);
        
        // class 변수를 사용하면 코드로 이름을 고정하므로 변경이 불가능하다.
        Class clazz = A.class;
        Class clazz2 = X.class;

                
    }
}
