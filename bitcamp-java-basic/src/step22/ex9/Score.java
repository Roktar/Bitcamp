package step22.ex9;

import java.io.Serializable;

// serialize와 transient modifier

public class Score implements Serializable{
    private static final long serialVersionUID = 1L;
    
    String name; // 사용자가 입력한 값
    int kor, eng, math; // 사용자가 입력한 값
    
    transient int sum; // 사용자가 입력한 값을 기준으로 컴퓨터가 계산한 값
    transient float avg; // 사용자가 입력한 값을 기준으로 컴퓨터가 계산한 값
    
    public Score( ) {
        System.out.println("Score");
    }
    
    public void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.avg = this.sum / 3f;
    }

    @Override
    public String toString() {
        return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
                + avg + "]";
    }
}
