package step02;

// 범위가 다른 것은 클래스와 메소드간의 차이만 인정되며 메소드간의 차이에서는 중복이 안된다.

public class Exam11_4 {
    public static void main(String[] args) {
        int a = 10;
        {
            //int a;
            //안쪽 블록에서는 바깥 블록의 변수를 사용할 수 있다.
            a = 150;

            int b = 300; // 이 블록에서만 사용가능
        }
        System.out.println(a);
        //System.out.println(b);

        {

            int b = 400;

        }
    }
}
