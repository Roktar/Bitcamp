package step06;

import java.util.Scanner;
//Array

public class Exam04_2 {
    static int[] getArray() {
        int[] arr = new int[] {100, 200, 300};

        return arr;
    }


    public static void main(String[] args) {  
        int[] arr;
        arr = getArray();

        System.out.printf("%d\n", arr[1]);
    }
}

// JVM => main 실행
// main => JVM Stack에 args, arr 변수 생성
// getArray => JVM Stack에 arr 변수, 힙에 배열 생성
// getArray 종료 => JVM Stack에 있던 arr 변수 제거하고 힙에 저장된 배열의 주소를 반환
// main 종료 => JVM Stack에서 main과 관련된 메모리를 제거
// JVM 종료 => 모든 메모리를 OS에 반납