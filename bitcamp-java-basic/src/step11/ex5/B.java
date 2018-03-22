package step11.ex5;

public class B extends A {
    int v2;
    // 여기서 A클래스의 코드를 자동으로 가져오는 것이 아니다.
    // B클래스는 A클래스의 링크 정보만 가지고있는 것이다.
    // 따라서 A클래스가 있어야하며, A클래스없이 B클래스 단독으로 사용은 불가능하다
    
    static {
        System.out.println("B class Static Block");
    }
}
