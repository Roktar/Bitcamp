package step22.ex3;

import java.io.FileOutputStream;

// int값 출력
public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        int money = 1_3456_7890;
        
        // 4바이트를 온전하게 입력하는 방법
        // 1바이트를 입력하는 write를 4번 호출한다. 그러면 4바이트 입력이 됨
        // 단, 원하는 자릿수를 지정해줘야한다.
        out.write(money >> 24); // 08 | 0557d2
        out.write(money >> 16); // 0805 | 57d2
        out.write(money >> 8); // 080557 : d2
        out.write(money); // 080557d2 | 

        out.close();
        System.out.println("기록 완료");
    }
}
