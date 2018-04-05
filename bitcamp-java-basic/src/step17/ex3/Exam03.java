package step17.ex3;

public class Exam03 {
    private int value;
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void test() {
        Inner iObj = new Inner();
        // inner 객체의 주소뿐만이 아닌 Exam02 객체의 주소도 전달된다. => Exam02.this를 의미
        iObj.m();
    }
    
    class Inner {
        public void m() {
            System.out.println(Exam03.this.getValue());
            Exam03.this.value = 150; // 어? private인데도 되네
        } // 상위 클래스의 this를 쓸 수 있다! 단, 클래스명을 붙여서.
    }
    
    // 위는 인스턴스 멤버임. => 인스턴스를 만들어야 한다.
    // 같은 클래스라고해도 인스턴스멤버는 해당 클래스의 인스턴스를 만들어야한다.
    // main은 static이기때문에 인스턴스 생성 없이도 처음에 메모리에 할당되고 실행된다.
    public static void main(String[] args) {
        Exam03 obj = new Exam03(); // 그래서 만듬.
        
        obj.setValue(100);
        
        // 내부클래스를 만들 때는 먼저 상위 클래스를 만들어야한다
        Inner iObj = obj.new Inner();
        // 하지만 이 방법을 쓸 일은 없을 것이다. 그렇게 봐도 무방.
        
        System.out.println(obj.getValue());
    }
}
