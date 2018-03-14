package step06;

import java.util.Scanner;

public class Exam02_6 {

    static void hello(String... names) {
        for(int i=0; i<names.length; i++)
        System.out.println(names[i] + "님, 반갑습니다.");
    }

    
    static void hello2(String[] names) {
        for(int i=0; i<names.length; i++)
        System.out.println(names[i] + "님, 반갑습니다.");
    }
    

    public static void main(String[] args) {  
        hello(); // 아규먼트가 0개로 length == 0이므로 실행하지않는다.
        System.out.println("--------------------------------");
        hello("홍길동", "임꺽정", "유관순");
        System.out.println("--------------------------------");
        // hello2("홍길동", "임꺽정", "유관순");
        System.out.println("--------------------------------");
        String[] arr = {"김구", "안중근", "윤봉길", "유관순"};
        hello2(arr);
    }
}