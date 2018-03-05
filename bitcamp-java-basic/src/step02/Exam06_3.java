package step02;

public class Exam06_3 { 
    public static void main(String[] args) {


       /* for(int i='다'; i<'다'+100; i++) {
            System.out.print( (char) i);
            if( (i % 10) == 0 )
                System.out.println();
        }*/

        for (int i=1; i<100; i++) {
            System.out.print( (char) ( ('가'-1) + i) );
            if ( (i%10) == 0 ) 
                System.out.println();
        }
            
    }
}