package step07.calculators;

public class Calculator4 {

    public int result = 0;
    
    public void plus(int val) { 
       this.result += val; 
    }
    public void minus( int val) {
        this.result -= val; 
    }
    public void multiply(int val) {
        this.result *= val; 
    }
    public void divide( int val) { 
        this.result /= val; 
    }
}
