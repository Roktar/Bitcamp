package step04;

public class Exam01_4 {
    public static void main(String[] args) {

        int i=5, j=2;
        float r = i / j;
        System.out.println(r);

        float f1 = 987.6543f;
        float f2 = 1.111111f;
        float f3 = f1+f2;
        double f4 = f1+f2;

        System.out.println(f3); // 988.7654(11) : float + float -> float
        System.out.println(f4); // 988.765380859375 : float을 double에 저장할 때 정확하게 저장이 되지않음 : IEEE754의 이진수변환 문제
        

    }
}