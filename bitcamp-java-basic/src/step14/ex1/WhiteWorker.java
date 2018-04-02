package step14.ex1;

// Worker 인터페이스 규칙을 이행하는 클래스 - 줄여서 Worker 구현체 라고 부름.
public class WhiteWorker implements Worker {

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.println("사무직 노동자가 일합니다.");
    }
    
}
