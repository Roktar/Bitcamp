package bitcamp.java106.step08;

import java.sql.Date;

public class Car {
    String model, maker;
    int cc;
    boolean auto;
    Date createdDate;
    Engine engine;

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
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        System.out.println("생성한 객체의 Date 값 : " + createdDate);
        this.createdDate = createdDate;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        System.out.println("생성한 객체의 auto 값 : " + auto);
        this.auto = auto;
    }
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", auto=" + auto + ", createdDate="
                + createdDate + ", engine=" + engine + "]";
    }
}
