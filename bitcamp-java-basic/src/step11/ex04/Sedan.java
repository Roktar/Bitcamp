package step11.ex4;

// 기존 클래스를 손대지않고 새 기능만 추가.

public class Sedan extends step11.ex1.Car {
    
    boolean sunroof;
    boolean auto;
    
    public Sedan( ) {
        super();
    }
    
    public Sedan(String model, String maker, int capacity, boolean sunroof, boolean auto) {
        super(model, maker, capacity);
        this.sunroof = sunroof;
        this.auto = auto;
    }
}
