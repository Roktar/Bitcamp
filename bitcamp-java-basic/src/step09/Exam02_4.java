package step09;

import java.util.Date;

public class Exam02_4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Date d1 = new Date();

        // instance Method
        System.out.println(d1.getYear() + 1900);
        System.out.println(d1.getMonth() + 1);
        System.out.println(d1.getDay());
        System.out.println(d1.getHours());
        
        // Static Method
        long millis = Date.parse("Sat, 12 Aug 1995 13:30:00 GMT");
        System.out.println(millis);
        
        // Static Method
        long curMillis = System.currentTimeMillis();
        
        // Constructor
        java.sql.Date today = new java.sql.Date(curMillis);
        
        System.out.println(today.toString());
        
        java.sql.Date d = java.sql.Date.valueOf("2018-03-20");
        System.out.println(d);
        
    }
}
