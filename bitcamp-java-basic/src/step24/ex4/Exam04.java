package step24.ex4;

// Thread 생명주기 - cpu 경쟁
public class Exam04 {
    
    public static void main(String[] args) throws Exception{        
        
        class MyThread extends Thread {
            public MyThread(String name) {
                super(name);
            }
            
            public void run() {
                for(int i=0; i<1000; i++)
                    System.out.printf("%s %d\n", this.getName(), i);
            }
        }

        MyThread t1 = new MyThread("홍길동==>");
        MyThread t2 = new MyThread("임꺽정-->");
        MyThread t3 = new MyThread("이몽룡##>");
        
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("쓰레드 실행 후");
    }
}