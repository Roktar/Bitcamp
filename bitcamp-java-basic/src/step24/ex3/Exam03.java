package step24.ex3;

// Thread 만들기 - Thread 클래스 상속 : 익명클래스
public class Exam03 {
    
    public static void main(String[] args) {        
        new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for(int i=0; i<1000; i++) {
                    System.out.println("===>" + i);
                }
            }
        }.start();
        // Thread를 익명클래스로 만든 후 인자로 Runnable 익명클래스를 인자로 넘겨준다.
        
        // main 쓰레드는 위의 t와 상관없이 병행하여 실행한다.
        for(int i=0; i<1000; i++) {
            System.out.println("===>" + i);
        }
    }
}
