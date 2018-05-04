package bitcamp.java106.step05;

import java.util.Arrays;
import java.util.List;

public class Car2 {
    String model, maker;
    int cc;
    Engine engine;
    List<Tire> tires;
    
    public Car2() {
        System.out.println("Car2() 호출");
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

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + ", tires=" + tires
                + "]";
    }
}
