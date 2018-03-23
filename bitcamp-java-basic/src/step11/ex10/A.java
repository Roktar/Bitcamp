package step11.ex10;

public class A {

    public static void m() {
        System.out.println("None");
    }    

    public static void m(int a) {
        System.out.println("int");
    }
    
    public static void m(String s) {
        System.out.println("String");
    }
    
    public static void m(String a, int b) {
        System.out.println("String, int");
    }
    
    public static void m(int a, String b) {
        System.out.println("int, String");
    }
}
