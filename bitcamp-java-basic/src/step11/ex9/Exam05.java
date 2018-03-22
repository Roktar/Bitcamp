package step11.ex9;

public class Exam05 {

    public static void print(Vehicle v) {
        System.out.println("[기본정보]");
        System.out.printf("모델명 : %s\n", v.model);
        System.out.printf("수용인원 : %d\n", v.capacity);
        
        // vehicle에 없는 요소들을 사용하기 위해서 v로 들어오는 객체의 클래스를 알아봐야한다.
        // instanceof 메소드르 쓴다.
        
        if(v instanceof Bike) {
            Bike b = (Bike)v;
            System.out.println("[바이크정보]");
            System.out.printf("엔진 유무 : %b\n", b.engine);
        } else if(v instanceof Car) {
            Car c = (Car)v;
            System.out.println("[자동차정보]");
            System.out.printf("밸브 : %s\n", c.valve);
            System.out.printf("CC : %s\n", c.cc);
        } else if(v instanceof Sedan) {
            Sedan s = (Sedan)v;
            System.out.println("[승용차정보]");
            System.out.printf("썬루프 : %s\n", s.sunroof);
            System.out.printf("변속 : %b\n", s.auto);
        } else if(v instanceof Truck) {
            Truck t = (Truck) v;
            System.out.println("[트럭정보]");
            System.out.printf("덤프 : %b\n", t.dump);
            System.out.printf("중량 : %.1f\n", t.ton);
        }
        System.out.println("------------------------------------------------");

    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
      // sedan, truck, bike의 모든 정보를 출력하라.
      // 제약사항으로는 한 개의 메소드를 사용한다.
      Sedan car1 = new Sedan();
      car1.model = "티코";
      car1.cc = 800;
      Truck car2 = new Truck();
      car2.model = "타이탄2";
      car2.cc=10000;
      
      Bike bike = new Bike();
      bike.model = "비트오토바이2018";
      bike.capacity = 2;
      bike.engine = true;
      
      Sedan sedan = new Sedan();
      sedan.model = "티코";
      sedan.capacity = 800;
      sedan.valve = 16;
      sedan.auto = true;
      sedan.sunroof = true;
      
      Truck truck = new Truck();
      truck.model = "타이탄II";
      truck.capacity = 3;
      truck.cc = 10000;
      truck.valve = 32;
      truck.dump = true;
      truck.ton = 15;
      
      print(bike);
      print(sedan);
      print(truck);

    }

}
