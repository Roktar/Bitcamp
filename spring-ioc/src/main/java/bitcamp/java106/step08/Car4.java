package bitcamp.java106.step08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

// 의존객체 Engine 주입 - Setter
public class Car4 {
    String model, maker;
    int cc;
    boolean auto;
    Date createdDate;
    Engine engine;

    public Car4(final Engine engine) {
        System.out.println("Car4 생성자 호출");
        this.engine = engine;
    } // 의존객체를 변경하지않을 것이라면, final을 붙여서 교체불가능하도록 설정한다.
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public Engine getEngine() {
        return engine;
    }
    
    public void setEngine(Engine engine) {
        System.out.println("Car2 setEngine()");
        this.engine = engine;
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", auto=" + auto + ", createdDate="
                + createdDate + ", engine=" + engine + "]";
    }
}
