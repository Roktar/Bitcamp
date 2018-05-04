package bitcamp.java106.step06;

public class Car {
    String model, maker;
    int cc;

    public Car() {
        System.out.println("Car() 호출");
    }
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        System.out.println("생성한 객체의 model 값 : " + model);
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("생성한 객체의 maker 값 : " + maker);
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        System.out.println("생성한 객체의 cc 값 : " + cc);
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + "]";
    }
}
