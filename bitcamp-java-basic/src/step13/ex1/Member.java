package step13.ex1;

public class Member {
    String name;
    int age;
    
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return  "[" + name + ", " + age + "]";
    }

}