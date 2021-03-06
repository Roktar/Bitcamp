package step12.ex2;

public class LinkedList {
    protected Bucket head, tail;
    
    protected class Bucket {
        public Object value;
        public Bucket prev, next;
    } // 자식클래스에서도 쓸 수 있도록 protected로 설정
   
    
    public LinkedList() {
        head = new Bucket();
        tail = head; // 시작점의 주소를 넘겨받는다.
    }
    
    public Object add(Object value) {
        tail.value = value;
        
        Bucket bucket = new Bucket();
        tail.next = bucket;
        
        bucket.prev = tail; // 헤드와 버킷을 연결
        
        tail = bucket; // 현재 끝은 bucket이므로 bucket의 주소를 넘김
        
        return tail.value;
    }
    
    public Object add(int i, Object value) {        
        Bucket bucket = new Bucket();
        bucket.value = value;
        
        Bucket cursor = head;
        int cnt = 0;
        
        int size = size();
        
/*        if(i==0) {
            if(head == tail)
                return null;
            bucket.next = head;
            head = bucket;
            return bucket.value;
        }*/
        
        while(cursor != tail) {
            if(cnt == i) {
                bucket.prev = cursor.prev;
                bucket.next = cursor;
                //cursor.prev.next = bucket;
                cursor.prev = bucket;
                
                if(bucket.prev != null)
                    bucket.prev.next = bucket;
                else
                    head = bucket;
                                
                return bucket.value;
            }
            cursor = cursor.next;
            cnt++;
        }
        
        if(cnt == i) 
            return (int)add(value);
                
        return null;
    }
    
    public Object get(int i) {
        Bucket cursor = head;
        int cnt = 0;
        
        while(cursor != tail) {
            if(cnt == i)
                return cursor.value;
            cursor = cursor.next;
            cnt++;
        }
        //throw new NullPointerException();
        return null;
    }
    
    public int size() {
        Bucket cursor = head;
        int cnt = 0;
        
        while(cursor != tail) {
            cnt++;
            cursor = cursor.next;
        }
        //throw new NullPointerException();
        return cnt;
        
        
        //return size;
    }
    
    public Object remove(int i) {
        Bucket cursor = head;
        int cnt = 0;
        
        if(i == 0) {
            if ( head == tail)
                return null;
            else {
                head = head.next;
                head.prev = null;
                return cursor.value;
            }
        }
        
        while(cursor != tail) {
            if(cnt == i) { // 현재 위치 기준으로 앞 노드와 뒤 노드를 서로 연결.
                // cursor에 현재 위치가 저장되어있으므로 아직 가비지는 안됨
                cursor.prev.next = cursor.next;
                cursor.next.prev = cursor.prev;
                return cursor.value;
                // 반환문이 끝나면 cursor도 사라지면서 연결된 객체가 없어져 가비지가 된다.
            }
            cursor = cursor.next;
            cnt++;
        }
        // size--;
        return -1;
    }
}
