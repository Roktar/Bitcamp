package step11.ex17;

// 이 클래스는 세단과 ㅇ트럭의 공통 기능을 관리하기 위해 만들어진 클래스.
// 즉, 직접 인스턴스를 만들어 사용하기 위한 클래스가 아니다.
// 세단과 트럭에서 겹치는 코드를 공통적으로 관리하기 위해 만든 클래스다.
// 직접 사용할 목적으로 만들어진 클래스가 아니기때문에 인스턴스를 만드는 것은 피해야한다.
public abstract class Car {

    public Car() {
        super();
    }

    public void start() {
        System.out.println("시동 걸기");
    }

    public void shutdown() {
        System.out.println("시동 끄기");
    }

    public void run() {
        System.out.println("주행");
    }

}