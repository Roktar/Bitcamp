package step12.ex1;

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
}
