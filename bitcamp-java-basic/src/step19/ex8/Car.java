package step19.ex8;

public class Car {
    Engine engine;
    
    public Car() {
        System.out.println("카 생성");
        this.engine = new Engine();
    }
    
    public void move() {
        this.engine.run();
        System.out.println("움직인다");
    }
}
