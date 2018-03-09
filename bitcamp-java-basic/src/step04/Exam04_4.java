package step04;

public class Exam04_4 {
    public static void main(String[] args) {

        int i = 0x27a130ff;
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);

        // i 변수에 들어있는 값을 1바이트씩 잘라서 16진수로 출력하라
        // for(int mask = -1; mask > i; mask = mask >> 4) {
        //     System.out.print( (i & mask) + " ");
        // }

        int mask1, mask2, mask3, mask4;
        mask1 = 0x000000ff; // or >>24 연산 후 0xff
        mask2 = 0x0000ff00; // or >>16 연산 후 0xff
        mask3 = 0x00ff0000; // or >>8 연산 후0xff
        mask4 = 0xff000000; // or 0xff
        
        System.out.println("2진수값 : " + Integer.toBinaryString(i));
        System.out.println("초기값 : " + Integer.toHexString(i));
        // System.out.println(Integer.toHexString((i & mask4) >> 24));
        // System.out.println(Integer.toHexString((i & mask3) >> 16));
        // System.out.println(Integer.toHexString((i & mask2) >> 8));
        // System.out.println(Integer.toHexString((i & mask1)));

        System.out.println( Integer.toHexString((i>>24)) );
        System.out.println( Integer.toHexString((i>>16) & 0xff) );
        System.out.println( Integer.toHexString((i>>8) & 0xff) );
        System.out.println( Integer.toHexString(i & 0xff) );
        // 이 방법은 오른쪽 8비트에 왼쪽에 있던 비트 8비트씩 끌어와서 세팅한다.
    }
}