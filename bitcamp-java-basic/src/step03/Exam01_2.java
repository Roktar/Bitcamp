package step03;

public class Exam01_2 {
    public static void main(String[] args) {

        class score { // 클래스를 이용한 것
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        // Score 인스턴스(=객체,메모리)의 주소를 저장할 배열 생성
        score[] sa = new score[3];
        score s = new score(), s2 = new score(), s3 = new score();

        s.name = "홍길동";
        s2.name = "임꺽정";
        s3.name = "유관순";

        System.out.printf("이름 : %s\n", s.name);
        System.out.printf("이름 : %s\n", s2.name);
        System.out.printf("이름 : %s\n", s3.name);

    }
}