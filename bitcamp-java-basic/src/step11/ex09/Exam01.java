package step11.ex9;

public class Exam01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Bike b= new Bike();
        Car c = new Car();
        Sedan s = new Sedan();
        Truck t = new Truck();
        
        Vehicle v2 = null;
        v2 = b;
        v2 = c;
        v2 = s;
        v2 = t;
        
        Bike b2 = null;
        b2 = v;
        b2 = c;
        b2 = d;
        
        Car c2=null;
        c2 = v;
        c2 = b;
        c2 = s;
        
        Sedan s2 = null;
        s2 = v;
        s2 = b;
        s2 = t;
        
        
        
/*        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        
        A a2 = null;
        a2 = b; // OK
        a2 = c; // OK
        a2 = d; // D
        
        B b2 = null;
        b2 = a; // ERROR
        b2 = c; //E
        b2 = d; //E
        
        C c2 = null;
        c2 = a;//E
        c2 = b;//E
        c2 = d;
        
        D d2 = null;
        d2 = a; //E
        d2 = b; //E
        d2 = c; //E
*/
    }

}
