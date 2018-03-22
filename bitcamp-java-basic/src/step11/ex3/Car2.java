package step11.ex3;

// 기존 코드를 복사해서 새 클래스 생성(ex2의 car와 같은 소스코드)
public class Car2 {
    String model;
    String maker;
    int capacity;
    boolean sunroof;
    boolean auto;
    
    public Car2() {
        
    }
    
    public Car2(String model, String maker, int capacity) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
    }
    
    public Car2(String model, String maker, int capacity, boolean sunroof, boolean auto) {
/*        this.model = model;
        this.maker = maker;
        this.capacity = capacity;*/
        // 위 코드는 중복이므로 위의 코드에 대해서만 처리하는 다른 생성자를 불러와서 처리가능하다.
        this(model, maker, capacity);
        
        this.sunroof = sunroof;
        this.auto = auto;
    }
}
