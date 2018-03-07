package step03;

public class Exam03_2 {
    public static void main(String[] args) {

        class score { // 클래스를 이용한 것
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        // 레퍼러스 선언과 동시에 인스턴스를 생성
        score s1 = new score();
        // s1에 저장된 주소를 s2에 복사한다.
        score s2 = s1;
        
    }
}