package step12.ex6;
// hash Map과 hashTable
import java.util.HashMap;
import java.util.Hashtable;

public class Exam03_1 {

    public static void main(String[] args) {
        
        HashMap map = new HashMap();
        Hashtable table = new Hashtable();
        
        map.put(null, "홍길동");
        map.put("s01", null);
        
        
        //table.put(null, "홍길동");
        //table.put("홍길동", null);
    }
}
