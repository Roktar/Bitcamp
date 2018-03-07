package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.GroupDescription;

public class App {
    public static void main(String[] args) {
        String[] question = {"팀명? ", "설명? ", "최대인원? ", "시작일? ", "종료일? "};
        Scanner sc = new Scanner(System.in);
        GroupDescription[] c_data = new GroupDescription[5];

        for(int i=0; i<5; i++) {
            c_data[i] = new GroupDescription();
            c_data[i].setData(i, sc, question);

            if( i != 4) {
                System.out.print("계속 입력하시겠습니까? (Y/N) ");

                String loop= sc.nextLine();
                if( loop.equals("N") || loop.equals("n") || !loop.equals("Y") && !loop.equals("y") )
                    break;
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        try {
            for(int i=0; i<c_data.length; i++)
                c_data[i].printData();
        } catch(NullPointerException e) { }
    }
}