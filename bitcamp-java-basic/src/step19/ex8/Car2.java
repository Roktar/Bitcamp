package step19.ex8;

public class Car2 {
    Engine engine;

    public Car2(Engine engine) {
        System.out.println("카2 생성");
        this.engine = engine;
    } // 외부에서 객체를 주입받는다.
    
    public void move() {
        this.engine.run();
        System.out.println("움직인다");
    }
}
