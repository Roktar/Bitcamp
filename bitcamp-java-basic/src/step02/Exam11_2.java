package step02;

public class Exam11_2 {
    int a; // instance Variable
    static int b; // Class Variable

    public static void main(String[] args) {
        int c; // Local Variable

        b = 20;

//        a = 100;

    }

    public static void m2() {
        b = 20;
        //a = 20;
    }    // static Method 
    
    public void m3() {
        a = 20;
    }    
    
    public void m4() {
        a = 20;
    }
}

// instance Variable
// - new 명령을 사용하여 인스턴스를 준비할 때 생성되는 변수
// class Variable
// - 클래스가 로딩될 때 생성되는 변수
// local variable
// 블록을 실행할 때 생성되는 변수