package step11.ex18;

public class Truck extends Car {
    
    @Override
    public void run() {
        System.out.println("덜컹덜컹 주행");
    }
    
    public void dump() {
        System.out.println("짐을 내린다.");
    }
}
