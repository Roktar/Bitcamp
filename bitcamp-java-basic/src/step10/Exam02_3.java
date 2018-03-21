package step10;

public class Exam02_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer obj1 = new Integer(100);
        Integer obj2 = new Integer(100);
        
        System.out.println(  (obj1 == obj2 ? "==" : "!=")  ); // 주소비교
        
        Integer obj3 = 100;
        Integer obj4 = 100;
        
        System.out.println(  (obj3 == obj4 ? "==" : "!=")  ); // 값비교
        
        int i = 100;
        Integer obj5 = new Integer(100);
        
        System.out.println(  (i == obj5 ? "==" : "!=")  );
        // Integer에서 오토언박싱 해서 비교하는 듯.
    }

}
