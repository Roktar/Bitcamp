package step12.ex5;

import java.util.ArrayList;

public class Exam01_2 {
    public static void main(String[] args) {
        String v1 = new String("aaa");
        String v2 = new String("bbb");
        String v3 = new String("ccc");
        String v4 = new String("ddd");
        String v5 = new String("ccc");
        
        ArrayList set = new ArrayList();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5);
        
        print(set);
        
        //hashset은 중복되는 값을 중복해서 저장하지않지만
        //ArrayList는 중복 여부에 관계없이 저ㅏ장한다.
        
    }
    
    
    static void print(ArrayList list) {
        Object[] arr = list.toArray();
        
        for(Object value : arr )
            System.out.print(value + ", ");
        System.out.println();
    }
}
