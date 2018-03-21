package step08;

public class Exam06_4 {

    static class A {
        static int a=30;
        int b;
        
        static {
            System.out.println("static block ");
        }
        
        {
            System.out.println("초기화 블록1 {}");
            
        } // 이렇게 아무이름없이 선언하는 블록은 초기화블록.
          // 생성자 호출 전에 자동적으로 생성된다.
        
        A() {
            this.a = 1 << 8;
            System.out.println("생성자 호출, a:" + a);
        }
        
        {
            System.out.println("초기화 블록2 {}");
        }
        
        static void m() {
        }
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        A obj;
        //A.a = 100;
        
        System.out.println("-----------");
        //A.m();
        
        System.out.println("***********");
        
        //new A();
        
        // 자바에서 제공하는 도구를 사용하여 강제로 클래스를 로딩시키는 경우
        Class.forName("step08.Exam06_4$A");


    }

}
