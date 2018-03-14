package step05;

public class Exam04_2 {
    public static void main(String[] args) {
       // for문 안에 선언된 변수는 for문을 나가는 순간 제거됨.
        for(int i=1; i<=5; i++)
            System.out.println(i);

        // 반복문 종류 뒤에 해당 변수의 값을 사용하고싶은 경우
        // 반드시 반복문 밖에 변수를 선언할 것.
        int i;
        for(i=0; i<=5; i++)
            System.out.println(i);

        System.out.println("for문 바깥 : " + i);
    }
}