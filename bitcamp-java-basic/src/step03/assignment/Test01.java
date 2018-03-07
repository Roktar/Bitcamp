package step03.assignment;

import java.util.Scanner;
import step03.Score;

public class Test01 {
    public static void main(String[] args) {
    
        //step03.Score list = new step03.Score[3]; // 이건 import 안했을 때 패키지명을 통해 쓰는 법.
        Score[] list = new Score[3];
        Scanner sc = new Scanner(System.in);
        
        // for(int i=0; i<list.length; i++)
        //     list[i] = new Score();

        // for(int i=0; i<list.length; i++) {
        //     System.out.print("입력 : ");
        //     list[i].name = sc.next();
        //     list[i].kor = sc.nextInt();
        //     list[i].eng = sc.nextInt();
        //     list[i].mat = sc.nextInt();
        //     list[i].avg = (list[i].sum = list[i].Sum()) / 3.0f;
        // }

        for(int i=0; i<list.length; i++) {
            list[i] = new Score();

            System.out.print("입력 : ");
            list[i].name = sc.next();
            list[i].kor = sc.nextInt();
            list[i].eng = sc.nextInt();
            list[i].mat = sc.nextInt();
            list[i].avg = (list[i].sum = list[i].Sum()) / 3.0f;
        }

        System.out.println("------------------------------------------------------");
        for(int i=0; i<list.length; i++)
            System.out.printf("%s %3d %3d %3d %3d %5.1f\n", list[i].name, list[i].kor, list[i].eng, list[i].mat, list[i].sum, list[i].avg);
    }
}