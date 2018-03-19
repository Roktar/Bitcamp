package step08;

public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        class A {
            int v1;
            boolean v2;
        }
        
        // 인스턴스 변수는 new 명령을 통해 생성된다.
        // new 명령 사용하기 전까지는 인스턴스 변수는 생성되지 않는다.
        // 생성위치 : 힙 영역
        // non-static
        A obj1 = new A();
        A obj2 = new A();
        A obj3 = new A();
        // new A();를 통해 인스턴스를 생성한다.
        // obj1~3은 그 인스턴스의 주소를 저장하므로 레퍼런스라고 부른다.
        // v1, v2를 인스턴스 변수라고 한다.
        
        obj1.v1 = 100;
        obj2.v1 = 200;
        obj3.v1 = 300;
        
        
        System.out.printf("%d %d %d", obj1.v1, obj2.v1, obj3.v1);
        
        
    }
}
