package step05;

public class Exam04_1 {
    public static void main(String[] args) {
        for(int i=1; i <= 5; i++)
            System.out.println(i);
        System.out.println("-------------------------------------------");
        for(int i=1; i<=5;) {
            System.out.println(i);
            i++;
        }
        System.out.println("-------------------------------------------");
        int i=1;
        for(; i<=5; i++)
            System.out.println(i);
        System.out.println("-------------------------------------------");
        i=1;
        for(;;) {
            if( i > 5)
                break;
            System.out.println(i);
            i++;
        }
    }
}