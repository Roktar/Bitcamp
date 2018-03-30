package step12.ex3;

import step12.ex2.LinkedList;

// LinkedList를 상속받아서 LinkedList도 같이 생성되기에 그 요소를 사용할 수 있따.
public class Stack extends LinkedList{

    public void push(Object value) {
        this.add(value);
    }
    
    public Object pop() {
        
        int size = this.size();
        if( (size-1) < 0) {
            System.out.println("Stack is Empty!!");
            return null;
        }
        return this.remove(size-1);

        
/*        if(this.head == this.tail)
            return null;
        
        Bucket removedBucket = this.tail.prev;
        if(this.tail.prev.prev != null) { // 현재 커서의 앞앞이 있을 때, 즉 최소 크기가 3이상일 때.
            this.tail.prev.prev.next = this.tail;
            this.tail.prev = this.tail.prev.prev;
        } else { // 크기가 2이하일 때.
            this.head = this.tail;
            this.head.prev = null;
        } // 리무브를 오버라이딩했다고 봐도 무방할 듯.
        
        return removedBucket.value;*/
        // 그냥 remove만 호출해도 될 거 같은데.. 흠
    }
    
}
