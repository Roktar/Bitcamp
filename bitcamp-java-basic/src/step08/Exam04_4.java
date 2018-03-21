package step08;
// 생성자 호출 막기


class Score {        
    String name;
    int kor, eng, math, sum;
    float avg;
    
    private Score() { // private이기때문에 외부에서 선언 불가
        name = "";
        kor = eng = math = sum = 0;
        avg = 0.0f;
        System.out.println("매개변수 없는 Score 생성자 호---출");
    }
    
    public void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.avg = this.sum / 3f;
    } 
}

public class Exam04_4 {    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Score s4 = new Score();
        
        //System.out.printf("%s %d %d %d %d %.1f\n", s4.name, s4.kor, s4.eng, s4.math, s4.sum, s4.avg);
    }
}
