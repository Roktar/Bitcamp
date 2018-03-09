package step04;

public class Exam06_4 {
    public static void main(String[] args) {
        int i = 2;
        int result = i++ + i++ * i++;
        // 순서 : result = 2 + 3 * 4 => 2 + (3*4) => 2 + 12 => 14

        System.out.printf("%d %d\n", i, result);
    }
}