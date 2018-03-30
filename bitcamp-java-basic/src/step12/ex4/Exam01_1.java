package step12.ex4;

import step12.ex2.LinkedList;

public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Queue queue = new Queue();

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
    
    static void print(LinkedList list) {
        for(int i=0; i<list.size(); i++) {
            System.out.print( list.get(i) + ", ");
        }
        System.out.println();
    }
}
