package step11.ex12;

public class Member2 extends Member {
    String name;
    int age;
    
    @Override
    public String toString() {

        return String.format("%s, %d", this.name, this.age);
    }
    
    @Override
    public int hashCode() {
        return String.format("%s, %d", this.name, this.age).hashCode();
    }
}
