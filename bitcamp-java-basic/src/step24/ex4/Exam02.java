package step24.ex4;

// Thread 생명주기
public class Exam02 {
    
    public static void main(String[] args) throws Exception{        
        System.out.println("쓰레드 실행 전");
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for(int i=0; i<10; i++) {
                    System.out.println("===>" + i);
                }
            }
        });
        t.start();
        
        t.join(); // t 스레드가 종료되기 전까지 main 메소드는 종료를 대기한다.
        
        System.out.println("쓰레드 실행 후");
        // main 호출이 끝나더라도 다른 스레드가 종료되기 전까지 JVM의 종료는 연기된다.
    }
}
