package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class App {
    static Calendar c = Calendar.getInstance();
    static Scanner sc = new Scanner(System.in);
    
    public static String getDay(int n) {
        switch(n) {
            default : break;
            case 1 : return "일";
            case 2 : return "월";
            case 3 : return "화";
            case 4 : return "수";
            case 5 : return "목";
            case 6 : return "금";
            case 7 : return "토";
        }
        return "";
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.print("입력(년, 월, 일 ex/ 2018 3 21) : ");
        c.set(sc.nextInt(), sc.nextInt()-1, sc.nextInt()); 
        // 월은 0부터 시작이기때문에 1감소시킴
        
        //String[] weeks = { "월", "화", "수", "목", "금", "토", "일" };
        
        System.out.println("요일:" + getDay(c.get(Calendar.DAY_OF_WEEK)) + "요일");
        //System.out.println("요일:" + weeks[c.get(Calendar.DAY_OF_WEEK) -1] + "요일");
        System.out.println("주차:" + c.get(Calendar.WEEK_OF_MONTH) + "주차");
        System.out.println("일차:" + c.get(Calendar.DAY_OF_YEAR) + "일차");
    }
}
