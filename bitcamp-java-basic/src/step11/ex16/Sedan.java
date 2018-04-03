package step11.ex16;

public class Sedan extends Car {
    
    @Override
    public void run() {
        System.out.println("주행");
    } // 트럭과느ㅜㄴ 서로 다르게 작업하므로 오버라이딩
    
    public void doSunroof(boolean isOpen) {
        if(isOpen)
            System.out.println("선루프 열기");
        else
            System.out.println("선루프 닫기");
    }
}
