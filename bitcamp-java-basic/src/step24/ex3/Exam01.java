package step24.ex3;

// Thread 만들기
public class Exam01 {
    
    public static void main(String[] args) {
        // Define thread
        class MyThread extends Thread {
            @Override
            public void run() {
                // 별도로 실행흐름을 분리하여 병행하여 실행한다.
                for(int i=0; i<1000; i++) {
                    System.out.println("===>" + i);
                }
            }
        } 
        // java.lang.Thread를 상속받아 만듬
        
        MyThread t = new MyThread();
        t.start();
        
        // main 쓰레드는 위의 t와 상관없이 병행하여 실행한다.
        for(int i=0; i<1000; i++) {
            System.out.println("===>" + i);
        }
    }
}
