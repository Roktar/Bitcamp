package step11.ex18;

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

    public abstract void run();
}