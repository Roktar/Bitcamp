package step17.ex3;

public class Exam01 {
    int value;
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
        
    // 위는 인스턴스 멤버임. => 인스턴스를 만들어야 한다.
    // 같은 클래스라고해도 인스턴스멤버는 해당 클래스의 인스턴스를 만들어야한다.
    // main은 static이기때문에 인스턴스 생성 없이도 처음에 메모리에 할당되고 실행된다.
    public static void main(String[] args) {
        Exam01 obj = new Exam01(); // 그래서 만듬.
        obj.setValue(100);
        
        System.out.println(obj.getValue());
    }
}
