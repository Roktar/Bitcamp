package step12.ex3;

import java.util.Stack;

public class Exam01_2 {

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
        while( stack.size() > 0  ) 
            System.out.println(stack.pop());
    }
    
    static void print(Stack list) {
        for(int i=0; i<list.size(); i++) {
            System.out.print( list.get(i) + ", ");
        }
        System.out.println();
    }
}
