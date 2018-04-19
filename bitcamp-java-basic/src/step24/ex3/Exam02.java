package step24.ex3;

// Thread 만들기 - Runable 인터페이스 구현
public class Exam02 {
    
    public static void main(String[] args) {
        // Define thread
        class MyRunnable implements Runnable {
            public void run() {
                
                for(int i=0; i<1000; i++) {
                    System.out.println(">" + i);
                }
            }
        } 
        // java.lang.Thread를 상속받아 만듬
        
        Thread t = new Thread(new MyRunnable());
        t.start();
        
        // main 쓰레드는 위의 t와 상관없이 병행하여 실행한다.
        for(int i=0; i<1000; i++) {
            System.out.println("===>" + i);
        }
    }
}
