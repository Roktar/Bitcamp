package step02.assignment;

import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {
        Object[] data = new Object[6];
        String[] question = {"이름? ", "국어? ", "수학? ", "영어? "};
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<4; i++) {
            System.out.print(question[i]);
            if(i==0) 
                data[i] = sc.nextLine();
            else
                data[i] = sc.nextInt();
        }

        data[5] = (int)(data[4] = (int)data[1] + (int)data[2] + (int)data[3] ) / 3.0f;
        System.out.println("-------------------------------");
        for(int i=0; i<6; i++)
            System.out.print( data[i] + " ");
    }
}