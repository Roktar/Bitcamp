package step24.ex1;

public class Exam02 {

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===>" + i);
            }
        }
    }

    public static void main(String[] args) {

        // 코드 실행 라인을 새로 만들어 따로 실행.
        
        new MyThread().start();
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>" + i);
        }
    }

}
