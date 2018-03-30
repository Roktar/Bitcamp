package step12.ex3;

import step12.ex2.LinkedList;

public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Stack stack = new Stack();

        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        stack.push(s1);
        print(stack);
        stack.push(s2);
        print(stack);
        stack.push(s3);
        print(stack);
        stack.push(s4);
        print(stack);
        stack.push(s5);
        print(stack);
/*        print(stack);
*/        
        String val;
        while( (val = (String)stack.pop() ) != null  ) 
            System.out.println(val);
    }
    
    static void print(LinkedList list) {
        for(int i=0; i<list.size(); i++) {
            System.out.print( list.get(i) + ", ");
        }
        System.out.println();
    }
}
