package step11.ex9;

public class Exam02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Vehicle v1 = new Sedan();
        Vehicle v2 = new Truck();
        
        // model, capacity 변수는 원래 Vehicle 변수에 설계도에 있는 변수다.
        // 그래서 당연히 레퍼런스를 통해 사용이 가능하다.
        v1.model = "티코";
        v1.capacity = 5;
        
        // 자바 컴파일러는 레퍼런스의 클래스를 보고 사용할 수 있는 변수/메소드인지 아닌지를 판단한다.
        // v1 변수에 Sedan 객체의 주소가 들어있다해도
        // 실제 들어있는 객체의 주소로 판단하지않고 레퍼런스가 어떤 클래스냐에 따라 판단한다.

        // 그럼에도 불구학 ㅗ레퍼런스가 실제 가리키는 객체의 모든 메모리에 접근하고 싶을 때는
        // 형변환을 해서 접근하면 된다.
        ((Sedan)v1).cc = 1980;
        ((Sedan)v1).valve = 16;
        ((Sedan)v1).sunroof = true;
        ((Sedan)v1).auto = true;
        
        System.out.printf("%s, %d, %d, %d, %b, %b\n", v1.model, v1.capacity, ((Sedan)v1).cc
                , ((Sedan)v1).valve, ((Sedan)v1).sunroof, ((Sedan)v1).auto);
        
        Sedan s = (Sedan) v1;
        
        System.out.printf("%s, %d, %d, %d, %b, %b\n", s.model, s.capacity, s.cc
                , s.valve, s.sunroof, s.auto);
        
    }

}
