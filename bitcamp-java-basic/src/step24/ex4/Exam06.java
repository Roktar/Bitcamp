package step24.ex4;

// Thread 생명주기 - cpu 경쟁
public class Exam06 {
    
    public static void main(String[] args) throws Exception{        
        
        class MyThread extends Thread {
            public MyThread(String name) {
                super(name);
            }
            
            public void run() {
                System.out.printf("t1 쓰레드 우선순위 : %d\n", this.getPriority());
                long startTime = System.currentTimeMillis();
                
                for(int i=0; i<100000000; i++)
                    Math.asin(38.567);
                
                long endTime = System.currentTimeMillis();
                System.out.printf("MyThread = %d\n", endTime - startTime);
            }
        }

        MyThread t1 = new MyThread("t1");
        t1.setPriority(10);
        t1.start();
        
        Thread.currentThread().setPriority(1);
        System.out.printf("main 쓰레드 우선순위 : %d\n", Thread.currentThread().getPriority());
        
        long startTime = System.currentTimeMillis();
        
        for(int i=0; i<100000000; i++)
            Math.asin(38.567);
        
        long endTime = System.currentTimeMillis();
        System.out.printf("main = %d\n", endTime - startTime);        
    }
}
