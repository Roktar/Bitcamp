package step13.ex2;

public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        LinkedList list = new LinkedList();
        
        list.add(new Member("홍길동", 20));
        list.add(new Member("임꺽정", 30));
        list.add(new Member("유관순", 16));
        
        for(int i=0; i<list.size(); i++) {
            Member member = (Member) list.get(i);
            System.out.printf("%s(%d)\n", member.name, member.age);
        }

     
    }
    
    static void print(LinkedList list) {
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i) + ", ");
        }
    }
}
