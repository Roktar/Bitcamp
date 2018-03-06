package step02.assignment;

import java.util.Scanner;

public class Test02 {

    public static void main(String[] args) {
        Object[][] data = new Object[5][6];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i < data.length; i++) {
            System.out.print("입력 ? ");
            for(int j=0; j < data[i].length-2; j++)
                data[i][j] = sc.next(); // 한 라인을 받는 거 같은데 공백, 개행문자 등 기준으로 문자열을 분할. 하지만 String Array 형태로는 반환되지 않으니 분할된 문자열 갯수만큼 넣기.
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