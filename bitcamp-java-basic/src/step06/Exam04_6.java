package step06;


// 재귀에서 종료조건이 없을 시 무한호출이 된다.

public class Exam04_6 {

    static int sum(int val) {
        // if(val==1)
        //     return 1;
        // System.out.println(val);
        long a1, a2, a3, a4, a5, a6, a7, a8, a9;
        long a11, a12, a13, a14, a15, a16, a17, a18, a19;
        long a111, a112, a113, a114, a115, a116, a117, a118, a119;

        System.out.println(val);

        return val + sum(val-1);
    }
    
    public static void main(String[] args) {  
        int r = sum(5);
        System.out.println(r);
    }
}