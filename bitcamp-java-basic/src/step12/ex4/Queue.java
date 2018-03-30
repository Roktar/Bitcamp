package step12.ex4;

import step12.ex2.LinkedList;

public class Queue extends LinkedList {
    
    public void offer(Object value) { // Enqueue
        this.add(value); // 맨 뒤에 삽입하므로 무조건 맨 뒤에만 붙이는 함수를 쓴다.
    }
    
    public Object poll() { // Dequeue
        
        return this.remove(0); // 맨 앞에서부터 꺼내오므로 맨 앞인 0번의 데이터를 꺼내온다.
        
/*        if(this.head == this.tail)
            return null;
        
        Bucket bucket = head;
        head = head.next;
        head.prev = null;
        return bucket.value;*/
    }
}
