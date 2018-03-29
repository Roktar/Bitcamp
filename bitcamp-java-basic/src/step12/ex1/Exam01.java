package step12.ex1;

public class Exam01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(100);
        
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        
        print(list);
        
        list.remove(4);
        
        print(list);
        
        list.remove(4);
        print(list);

        list.add(1, "xxx");
        list.add(1, "yyy");
        
        list.set(1, "www");
        
        print(list);
        
    }
    
    public static void print(ArrayList list) {
        for (int i=0; i < list.size(); i++)
            System.out.print(list.get(i) + ", ");
        System.out.println();
    }
}
