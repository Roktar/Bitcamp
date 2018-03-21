package step08;

public class Exam06_2 {

    static class A {
        int a;
        int b;
        
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
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // 오브젝트 클래스를 상속받은 익명클라스
        Object obj1 = new Object() {
            {
                System.out.println("초기화블럭.");
            }
        };

    }

}
