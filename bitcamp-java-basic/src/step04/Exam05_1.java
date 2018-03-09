package step04;

public class Exam05_1 {
    public static void main(String[] args) {
        int age = 20;
        //(age > 18 ? System.out.println("성인이다.") : System.out.println("미성년자이다."));
        // sysout은 void로 결과를 리턴하지 않는다. 그래서 에러임.
        String msg = (age > 18 ? "성년" : " 미성년자");
        System.out.printf("나이 %d은(는) %s이다.\n", age, msg);
    }
}