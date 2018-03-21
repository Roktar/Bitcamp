package step09.singletone;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 아래는 public으로 생성자가 설정되어잇기때문에 외부에서 new 선언 가능
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();
        System.out.println("");
        // 아래는 private으로 생성자가 설정되어있어서 내부에서만 new 가능
        Car2 c4 = Car2.getInstance();
        Car2 c5 = Car2.getInstance();
        Car2 c6 = Car2.getInstance();
        
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        
    }

}
