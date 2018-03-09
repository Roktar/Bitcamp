package step04;

public class Exam06_8 {
    public static void main(String[] args) {
        int i = 2;
        int result = ++i + ++i * ++i;
        // 3 + 4 * 5 

        System.out.println(result);

        // 리터럴에는 적용 불가
        // int x = ++100;
        // x = 100++;
        
    }
}