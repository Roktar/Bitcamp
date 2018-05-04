package bitcamp.java106.step06;

import org.springframework.beans.factory.FactoryBean;
// 스프링 IoC 컨테이너가 정한 규칙에 따라 공장클래스를 만들 경우,
// 스프링을 사용하여 보다 쉽게 객체를 생성할 수 있다.
public class CarFactoryBean implements FactoryBean {
    String model;
    
    public CarFactoryBean() {
        System.out.println("CarFactory3 생성자 호출");
    }
    
    public void setModel(String model) {
        System.out.println("model 정보를 프로퍼티로 받아서 입력 : " + model);
        this.model = model;
    }
    
    @Override
    public Car getObject() throws Exception { // 객체를 반환하는 메소드
        // TODO Auto-generated method stub
        
        System.out.println("getObject 함수 호출");
        
        Car c = new Car();
        switch(model) {
            case "티코" :
                c.setMaker("대우자동차");
                c.setModel("Tico");
                c.setCc(890);
                return c;
            case "소나타" :
                c.setMaker("현대자동차");
                c.setModel("Sonata");
                c.setCc(1980);
                return c;
            case "SM5" :
                c.setMaker("르노삼성자동차");
                c.setModel("SM5");
                c.setCc(1990);
                return c;
            default :
                c.setMaker("비트자동차");
                c.setModel("자바휘웅");
                c.setCc(5000);
                return c;
        }
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        System.out.println("getObjectType 호출됨");
        return Car.class;
    }
}
