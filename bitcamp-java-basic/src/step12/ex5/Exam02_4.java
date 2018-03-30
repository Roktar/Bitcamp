package step12.ex5;

import java.util.Iterator;

import java.util.concurrent.ArrayBlockingQueue;

public class Exam02_4 {
    public static void main(String[] args) {
        String v1 = new String("aaa");
        String v2 = new String("bbb");
        String v3 = new String("ccc");
        String v4 = new String("ddd");
        String v5 = new String("ccc");
        
        ArrayBlockingQueue Stack = new ArrayBlockingQueue(100);
        Stack.add(v1);
        Stack.add(v2);
        Stack.add(v3);
        Stack.add(v4);
        Stack.add(v5);
        
        // 순서대로 저장되는 것이 아니다. 즉, 인덱스를 통해 꺼내오는 건 불가능하다.
        
        //print(set);
        
        //set.get(0); // 이런 게 불가능.
        Iterator 컬렉션에서_값을_꺼내주는_객체 = Stack.iterator();
        
        while(컬렉션에서_값을_꺼내주는_객체.hasNext()) {
            System.out.printf(컬렉션에서_값을_꺼내주는_객체.next() + ", ");  
        }
    }
    
    
    static void print(ArrayBlockingQueue list) {
        Object[] arr = list.toArray();
        
        for(Object value : arr )
            System.out.print(value + ", ");
        System.out.println();
    }
}
