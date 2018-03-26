package step11.ex13;

public class Customer3 {
    private String name;
    private int age, weight, height;
    
    // 외부에서 접근하게 할 수 있는 수단을 제공해야한다. 아래는 그 수단.
    
    public void setName(String name) {
        if(this.name == null || name.length() < 2)
            this.name = "이름없음";
        else
            this.name = name.substring(0, 5);
    }
    public void setAge(int age) {
        if(age > 0 && age < 150)
            this.age = age;
        else 
            this.age = -1;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}