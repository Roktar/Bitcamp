package step17.ex3;

import java.util.Iterator;

public class ArrayList {
    
    public class MyIterator { // ArrayList에서 데이터를 찾아온다.
        int index = 0;
        // MyIterator 클래스에서 관리하는 인덱스
        public boolean hasNext() {
            if(this.index < ArrayList.this.cursor)
                return true;
            
            return false;
        }

        public Object next() {
            return ArrayList.this.list[this.index++];
        }
    }
    
    protected static final int DEFAULT_CAPACITY = 5;
    
    Object[] list;
    int cursor;
    
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(int capacity) {
        //super();이 자동적으로 호출된다.
        if(capacity > 5 )
            list = new Object[capacity];
        else
            list = new Object[DEFAULT_CAPACITY];
    }
    
    public void add(Object val) {
        if(cursor >= list.length) {
            Object[] list2 = this.increaseArray(list);
            
            for(int i=0; i<list.length; i++)
                list2[i] = list[i];
            
            list = list2;
        }
        list[cursor++] = val;
    }
    
    public void add(int index, Object value) {
        if(index > cursor || index < 0 )
            return;
        
        if(cursor >= list.length) {
            Object[] list2 = this.increaseArray(list);
            
            for(int i=0; i<list.length; i++)
                list2[i] = list[i];
            
            list = list2;
        }
        
        for(int i = cursor-1; i >= index; i--)
            list[i+1] = list[i];
        list[index] = value;
        cursor++;
    }
    
    public Object get(int index) {
        return list[index];
    }
    
    public void set(int index, Object value) {
        if(index > cursor || index < 0 )
            return;
        
        list[index] = value;
    }
    
    public void remove(int index) {
        
        if(index > cursor || index < 0 )
            return;
        
/*        for(int i = index; i < cursor-1; i++)
            list[i] = list[i+1];*/
        for(int i = index+1; i < cursor; i++)
            list[i-1] = list[i];
        
        cursor--;
    }   
    
    public int size() {
        return cursor;
    }
    
    public Object[] increaseArray(Object[] list) {
        return new Object[list.length + 1];
    }

    public int indexOf(Object value) {
        for(int i=0; i < list.length; i++) {
            if(list[i].equals(value))
                return i;
        }
        return -1;
    }
    
    public boolean contains(Object o) {
        for (Object obj : list) { 
            if (obj.equals(o)) // 같은 객체가 있는 지 검사하는 것이 아닌 같은 내용을 가진 객체가 있는 지 검사한다.
                return true;
        }
        return false;
    }
    
    public MyIterator iterator() {
        
        // MyIterator를 만들 때 현재 ArrayList 객체 주소를 넘긴다.
        // 즉 MyIterator는 객체가 만들어지는 순간에 바깥 클래스의 객체 주소를 알게된다.
        return new MyIterator(); // ArrayList의 주소도 알게됨.
        // 데이터를 담은 객체를 만드는 게 아닌 ArrayList의 내부 클래스를 만들어서 내보낸다.
        // => 이미 만들어진 ArrayList 객체를 통해 만들어지므로 그 객체의 주소를 알고있다.
        // => 그 주소에 있는 모든 요소를 MyIterator가 사용할 수 있따는 것이다.
        // 즉, hasNext와 next만을 가지는 ArrayList의 데이터에 접근할 수 있는 객체만을 만드는 것이다.
    }
}
