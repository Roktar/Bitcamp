package step22.ex9;

// 인스턴스의 값을 바이트 배열로 자동변환할 수 있도록 허가하는 것 => Serializable 인터페이스를 구현한다
public class Member2 implements java.io.Serializable {
    String name;
    int age;
    boolean gender;
    String tel;
    
    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + ", gender=" + gender + ", tel=" + tel + "]";
    }
}
