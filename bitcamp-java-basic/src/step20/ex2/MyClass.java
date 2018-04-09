package step20.ex2;

@MyAnnotation("값")
@MyAnnotation2("값")
@MyAnnotation3("값")
public class MyClass {
    @MyAnnotation(value="값")
    int i;
    @MyAnnotation(value="값")
    public void m(@MyAnnotation("값") String p) {
        @MyAnnotation("값") int local;
        
/*        @MyAnnotation("값")
        if(true) {
            
        }*/
    }
    
}
