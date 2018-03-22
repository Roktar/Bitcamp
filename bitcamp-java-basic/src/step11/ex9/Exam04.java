package step11.ex9;

public class Exam04 {

    public static void printSedan(Truck s) {
        System.out.printf("모델명 : %s\n", s.model);
        System.out.printf("cc : %d\n", s.cc);
        System.out.println("---------------------------");
    }
    
    public static void printSedan(Sedan s) {
        System.out.printf("모델명 : %s\n", s.model);
        System.out.printf("cc : %d\n", s.cc);
        System.out.println("---------------------------");
    }
    
    public static void print(Car s) {
        System.out.printf("모델명 : %s\n", s.model);
        System.out.printf("cc : %d\n", s.cc);
        System.out.println("---------------------------");
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
      Sedan car1 = new Sedan();
      car1.model = "티코";
      car1.cc = 800;
      Truck car2 = new Truck();
      car2.model = "타이탄2";
      car2.cc=10000;
      
      // 다형적 변수를 사용하면 동일한 코드를 갖고있는 위의 메소드를
      // 한개의 메소드로 통합할 수 있다.
      // 즉, Sedan 객체와 Truck 객체를 모두 가리킬 수 있는 레퍼런스를 선언하라
      // 여기서 저 두 객체의 상위는 Car 클래스다.
      // 그러므로 매개변수를 car로 갖는 메소드를 만들어서 활용하면 된다.
      print(car1);
      print(car2);
        
    }

}
