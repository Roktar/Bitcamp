package step09.singletone;

public class Car2 {
    
    private static Car2 car2 = null;
    // 스태틱 변수라서 힙에 저장되지않는다. 메소드 영역에 저장됨
    
    private Car2() {
        System.out.println("Car2()");
    }
    
    public static Car2 getInstance() {
        if(car2 == null)
            car2 = new Car2();
        
        return car2;
    }
}
