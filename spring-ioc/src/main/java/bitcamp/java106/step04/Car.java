package bitcamp.java106.step04;

public class Car {
    String model, maker;
    int cc;
    Engine engine;
    
    public Car() {
        System.out.println("Car() 호출");
    }
    
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
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
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + "]";
    }
}
