package step22.ex9;

// 인스턴스의 값을 바이트 배열로 자동변환할 수 있도록 허가하는 것 => Serializable 인터페이스를 구현한다
public class Member3 implements java.io.Serializable {
    // 시리얼라이저블 인터페이스를 구현하는 모든 클래스는 
    // 반드시 시리얼 데이터의 버전을 식별할 때 사용할 번호를 지정해야한다.
    public static final long serialVersionUID = 7;
    String name;
    int age;
    boolean gender;
    String tel;
    
    @Override
    public String toString() {
        return "Member3 [name=" + name + ", age=" + age + ", gender=" + gender + ", tel=" + tel + "]";
    }
}
