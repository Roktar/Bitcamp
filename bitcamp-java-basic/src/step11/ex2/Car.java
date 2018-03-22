package step11.ex2;

// 방법 1. 기존 클래스를 수정했다. (ex1의 car 클래스를 수정)
public class Car {
    String model;
    String maker;
    int capacity;
    boolean sunroof;
    boolean auto;
    
    public Car() {
        
    }
    
    public Car(String model, String maker, int capacity) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
    }
    
    public Car(String model, String maker, int capacity, boolean sunroof, boolean auto) {
/*        this.model = model;
        this.maker = maker;
        this.capacity = capacity;*/
        // 위 코드는 중복이므로 위의 코드에 대해서만 처리하는 다른 생성자를 불러와서 처리가능하다.
        this(model, maker, capacity);
        
        this.sunroof = sunroof;
        this.auto = auto;
    }
}
