package bitcamp.java106.step05;

import java.util.Map;
import java.util.Properties;

public class Car4 {
    String model, maker;
    int cc;
    Engine engine;
    Properties options;
    
    public Car4() {
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

    public Properties getOptions() {
        return options;
    }

    public void setOptions(Properties options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car4 [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + ", options="
                + options + "]";
    }
}
