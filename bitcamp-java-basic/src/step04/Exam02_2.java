package step04;

public class Exam02_2 {
    public static void main(String[] args) {
        int a = 10, b = 20;
        boolean b1 = a < b;

        System.out.println(a < b);
        System.out.println(a <= b);
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a == b);
        System.out.println(a != b);

        double f1 = 987.6543, f2 = 1.111111f;
        System.out.println( (f1+f2) == 988.764511 );

        double EPSILON = 0.00001;
        System.out.println(Math.abs( (f1 + f2) - 988.765411 ) < EPSILON);

        double x = 234.765411;
        double y = 754.0;
        System.out.println(  (f1+f2) == (x+y) );
        System.out.println( Math.abs( (f1+f2) - (x+y) )  < EPSILON );

    }
}