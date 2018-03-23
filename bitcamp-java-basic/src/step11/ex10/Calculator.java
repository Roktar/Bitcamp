package step11.ex10;

public class Calculator {
    static int plus(int a, int b) {
        return a+b;
    }
    
    static int plus(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }
    
    static float plus(float a, float b) {
        return a+b;
    }
}
