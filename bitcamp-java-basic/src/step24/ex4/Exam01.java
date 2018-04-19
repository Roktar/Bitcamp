package step24.ex4;

// Thread 생명주기
public class Exam01 {
    
    public static void main(String[] args) {        
        System.out.println("쓰레드 실행 전");
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for(int i=0; i<10; i++) {
                    System.out.println("===>" + i);
                }
            }
        }).start();
        
        System.out.println("쓰레드 실행 후");
    }
}
