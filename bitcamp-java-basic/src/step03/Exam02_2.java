package step03;

public class Exam02_2 {
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
        // 각 레퍼런스에 인스턴스를 만들어 주소를 저장
        sa[0] = new score();
        sa[1] = new score();
        sa[2] = new score();

        sa[0].name = "홍길동";
        sa[1].name = "임꺽정";
        sa[2].name = "유관순";

        // 레퍼런스를 통해 인스턴스의 각 항목값을 추출
        System.out.printf("이름 : %s\n", sa[0].name);
        System.out.printf("이름 : %s\n", sa[1].name);
        System.out.printf("이름 : %s\n", sa[2].name);

    }
}