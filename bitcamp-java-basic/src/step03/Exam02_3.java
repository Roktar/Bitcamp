package step03;

public class Exam02_3 {
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

        for(int i=0; i<sa.length; i++)
            sa[i] = new score();
        
        // 값은 서로 다를 수 있기때문에 반복문이 아닌 수동으로 직접 넣는다.
        sa[0].name = "홍길동";
        sa[1].name = "임꺽정";
        sa[2].name = "유관순";

        // 반복문을 통해 배열의 인스턴스 값을 추출
        for(int i=0; i<sa.length; i++)
            System.out.printf("이름 : %s\n", sa[i].name);
    }
}