package step24.ex2;

public class Exam02 {
    public static void main(String[] args) {
        // 이 순간, 실행 중인 흐름이 무엇인지 알기위해서는 다음과 같이 사용하면 된다.
        Thread t = Thread.currentThread();
        // 위에는 현재 실행중인 쓰레드가 담긴다.
        
        // 쓰레드는 그룹으로 묶일 수 있다.
        // 그룹 단위로 쓰레드를 시작시키고 멈추기도 가능.
        // 현재 쓰레드가 소속된 그룹을 알고싶으면 다음과 같이 사용한다.
        ThreadGroup group = t.getThreadGroup();
        System.out.println("실행중인 쓰레드 그룹 : " + group.getName());
        
        
    }
}
