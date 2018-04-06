package step19.ex9;

@Component(value="car")
public class Car {
    Engine engine;

    public Car(Engine engine) {
        System.out.println("카 생성(engine)");
        this.engine = engine;
    } // 외부에서 객체를 주입받는다.
    
    public void move() {
        this.engine.run();
        System.out.println("움직인다");
    }
}
