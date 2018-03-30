package step12.ex5;

import java.util.Iterator;

import java.util.LinkedList;

public class Exam02_2 {
    public static void main(String[] args) {
        String v1 = new String("aaa");
        String v2 = new String("bbb");
        String v3 = new String("ccc");
        String v4 = new String("ddd");
        String v5 = new String("ccc");
        
        LinkedList set = new LinkedList();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5);
        
        // 순서대로 저장되는 것이 아니다. 즉, 인덱스를 통해 꺼내오는 건 불가능하다.
        
        //print(set);
        
        //set.get(0); // 이런 게 불가능.
        Iterator 컬렉션에서_값을_꺼내주는_객체 = set.iterator();
        
        while(컬렉션에서_값을_꺼내주는_객체.hasNext()) {
            System.out.printf(컬렉션에서_값을_꺼내주는_객체.next() + ", ");  
        }
    }
    
    
    static void print(LinkedList list) {
        Object[] arr = list.toArray();
        
        for(Object value : arr )
            System.out.print(value + ", ");
        System.out.println();
    }
}
