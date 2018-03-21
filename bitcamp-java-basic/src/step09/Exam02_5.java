package step09;

import java.util.Calendar;

// use Class : Calendar
public class Exam02_5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar c = Calendar.getInstance();
        
        System.out.println(c.get(1)); // year
        System.out.println(c.get(2)+1); // month count (0~11)
        System.out.println(c.get(4)); // week count
        System.out.println(c.get(5)); // day count
        System.out.println(c.get(7)); // day(1~7) sun,mon,tue, ...
        System.out.println(c.get(10)); // hour (0~11)
        System.out.println(c.get(11)); // hour (24 hour)
        System.out.println(c.get(12)); // minuites
        System.out.println(c.get(13)); // seconds
        System.out.println("--------------------------");
        System.out.println(c.get(Calendar.YEAR)); // year
        System.out.println(c.get(Calendar.MONTH)+1); // month count (0~11)
        System.out.println(Calendar.WEEK_OF_MONTH); // week count
        System.out.println(Calendar.DAY_OF_WEEK); // day count
        System.out.println(Calendar.DATE); // day(1~7) sun,mon,tue, ...
        System.out.println(Calendar.HOUR); // hour (0~11)
        System.out.println(Calendar.HOUR_OF_DAY); // hour (24 hour)
        System.out.println(Calendar.MINUTE); // minuites
        System.out.println(Calendar.SECOND); // seconds
    }

}
