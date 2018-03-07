package step02;

public class Exam09_4 { 
    public static void main(String[] args) {
        int[] arr = new int[] {100, 200, 300}; // 선언과 동시에 초기화

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

        arr = new int[] {10, 20, 30, 40, 50};
        
        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i]);

    }
}