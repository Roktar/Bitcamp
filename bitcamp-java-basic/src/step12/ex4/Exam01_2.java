package step12.ex4;

import java.util.concurrent.ArrayBlockingQueue;

public class Exam01_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ArrayBlockingQueue queue = new ArrayBlockingQueue(100);

        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        queue.offer(s1);
        print(queue);
        queue.offer(s2);
        print(queue);
        queue.offer(s3);
        print(queue);
        queue.offer(s4);
        print(queue);
        queue.offer(s5);
        print(queue);
/*        print(queue);
*/        
        String val;
        while( (val = (String)queue.poll() ) != null  ) 
            System.out.println(val);
    }
    
    static void print(ArrayBlockingQueue list) {
        Object[] arr = list.toArray();
        
        for(Object value : arr ) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}
