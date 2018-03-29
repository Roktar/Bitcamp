package step12.ex2;

public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        LinkedList list = new LinkedList();

        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        list.add(s1);
        list.add(s2);
        list.add(1, s3);
        list.add(1, s4);
        list.add(0, s5);
        list.add(5, s5);
/*        list.add(s3);
        list.add(s4);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.size());
        System.out.println("삭제된 값 : " + list.remove(0));
        System.out.println("삭제된 값 : " + list.remove(1));
        System.out.println("삭제된 값 : " + list.remove(2));*/
        print(list);
        
        //list.add(1, s5);
    }
    
    static void print(LinkedList list) {
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i) + ", ");
        }
    }
}
