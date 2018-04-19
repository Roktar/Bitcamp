package step24.ex4;

// Thread 생명주기
public class Exam03 {
    
    public static void main(String[] args) throws Exception{        
        System.out.println("쓰레드 실행 전");
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("HELLO");
            }
        }).start();
        
        Thread.currentThread().sleep(3000);
        // 3초동안 not runnable 상태로 만든다. => cpu가 유휴상태여도 cpu를 사용하지 않는다.
        
        System.out.println("쓰레드 실행 후");
    }
}
