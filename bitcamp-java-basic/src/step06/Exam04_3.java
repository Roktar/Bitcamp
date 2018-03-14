package step06;

import java.util.Scanner;
//Instance

public class Exam04_3 {
    static MyObject getObject() {
        MyObject ref; // JVM Stack영역에 만들어지는 변수
        ref = new MyObject(100, 200); // Heap 영역에 만들어지는 인스턴스의 주소를 변수에 등록
        // 여기서 ref는 가리키기만 할 뿐이다. 즉, ref가 가리키는 주소의 인스턴스.
        System.out.println("in method hashcode : " + ref);

        return ref;
    }


    public static void main(String[] args) {  
        MyObject arr = new MyObject();
        System.out.println("in main hashcode : " + arr);

        arr = getObject();

        System.out.println("after getObject in main hashcode : " + arr);

        System.out.printf("%d\n", arr.b);
    }
}

class MyObject {
    int a, b;

    public MyObject() {

    }
 
    public MyObject(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

// JVM => Exam04_4.class, MyObject.class 실행, Exam04_4에서 main을 찾아 실행.
// main => JVM Stack에 args, arr 변수 생성
// getObject => JVM Stack에 ref 변수, 힙에 배열 생성,  Method Area에 MyObject 클래스 로딩
// getArray 종료 => JVM Stack에 있던 arr 변수 제거하고 힙에 저장된 배열의 주소를 반환
// main 종료 => JVM Stack에서 main과 관련된 메모리를 제거
// JVM 종료 => 모든 메모리를 OS에 반납