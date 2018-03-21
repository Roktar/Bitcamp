package step10;

public class Exam02_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int i1 = 100;
        
        Integer obj1 = new Integer(i1);
        Integer obj2 = new Integer(200);
        
        int i2 = obj2.intValue();
        
        //JDK 1.5부터 오토 박싱, 오토 언박싱 기능이 제공된다.
        Integer obj3 = i1; // 내부적으로 new Integer(i1)로 처리된다.

        Integer obj4 = new Integer(300);
        int i3 = obj4; // 내부적으로 obj4.intValue()로 처리된다.
                       // 주소가 아닌 인스턴스에 들어있는 값을 꺼내 저장하는 것.
    }

}
