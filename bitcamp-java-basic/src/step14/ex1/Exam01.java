package step14.ex1;

public class Exam01 {
    public static void main(String[] args) {
        Worker w1 = new BlueWorker();
        //Worker ws = new String(); // Worker 인터페이스 규칙을 이행하지않아서 불가
        Worker w2 = new WhiteWorker();
        Worker w3 = new JubuWorker();
        
        w1.execute();
        w2.execute();
        w3.execute();
        
        // caller : Exam01
        // callee : Blue, White, Jubu Worker
        // 여기서의 규칙 : Worker
    }
}
