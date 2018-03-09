package step04;

public class Exam06_7 {
    public static void main(String[] args) {
        int i = 2;

        i = ++i;
        // i = i +1을 먼저 수행
        // i의 값 : 3, 3인데 또 3을 넣는다.

        System.out.println(i);
    }
}