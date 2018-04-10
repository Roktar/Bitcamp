package step21.ex3;

import java.io.FileReader;
import java.util.Scanner;
// auto-closable
public class Exam06_4 {
    static class A {}
    static class B implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("자원해제햇슴");
        }
    }
    
    static void m() throws Exception {
        try ( 
                //A obj1 = new A(); // AutoCloseable 구현체가 아님
                B obj2 = new B(); // AutoCloseable 구현체라서 에러 안남
                B obj3 = null;
            ) {
               obj3 = new B(); // 단, () 내부에서 인스턴스까지 생성해야한다. 외부에서 인스턴스생성을 할 수는 없다.
        } // autoClosable을 사용하였기에 finally에서 자원해제를 해줄 필요성이 없다.
    }
    
    public static void main(String[] args) throws Exception {
        m();
    }
}
