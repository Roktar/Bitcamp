package step24.ex2;

// 현재 실행 라인을 알아내기
public class Exam01 {
    public static void main(String[] args) {
        // 이 순간, 실행 중인 흐름이 무엇인지 알기위해서는 다음과 같이 사용하면 된다.
        Thread t = Thread.currentThread();
        System.out.println("실행중인 쓰레드 : " + t.getName());
    }
}
