package step12.ex1;

import java.util.Arrays;

public class ArrayList {
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

/*    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cursor;
        result = prime * result + Arrays.hashCode(list);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArrayList other = (ArrayList) obj;
        if (cursor != other.cursor)
            return false;
        if (!Arrays.equals(list, other.list))
            return false;
        return true;
    }*/
    
    public int indexOf(Object value) {
        for(int i=0; i < list.length; i++) {
            if(list[i].equals(value))
                return i;
        }
        return -1;
    }
    
    public boolean contains(Object o) {
        for (Object obj : list) {
            /*if (obj.hashCode() == o.hashCode() && obj.equals(o))
                return true;*/            
            if (obj.equals(o)) // 같은 객체가 있는 지 검사하는 것이 아닌 같은 내용을 가진 객체가 있는 지 검사한다.
                return true;
        }
        return false;
    }
}
