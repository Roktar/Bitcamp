package step02.assignment;

import java.util.Scanner;

public class Test02 {

    public static void main(String[] args) {
        Object[][] data = new Object[5][6];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i < data.length; i++) {
            System.out.print("입력 ? ");
            for(int j=0; j < data[i].length-2; j++)
                data[i][j] = sc.next();
            data[i][5] = (int)( data[i][4] = getIntValue(data[i][1], data[i][2], data[i][3]) ) / 3.0f;
            sc.nextLine();
        }

        System.out.println("-------------------------------");
        
        printData(data);
        sc.close();
    }

    public static int getIntValue(Object... args) {
        int ret = 0;
        for (int i=0; i<args.length; i++)
            ret += Integer.parseInt( (String)args[i] );
        return ret;
    }

    public static void printData(Object[][] data) {
        for(int i=0; i<data.length; i++)
            System.out.println(data[i][0] + " " + data[i][1] + " " + data[i][2] + " " + data[i][3] + " " + data[i][4] + " " + String.format( "%.1f", (float)data[i][5] ));
    }
}