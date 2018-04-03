package step11.ex15;

public class Sedan {
    public void start() {
        System.out.println("시동 걸기");
    }

    public void shutdown() {
        System.out.println("시동 끄기");
    }

    public void run() {
        System.out.println("주행");
    }
    public void doSunroof(boolean isOpen) {
        if(isOpen)
            System.out.println("선루프 열기");
        else
            System.out.println("선루프 닫기");
    }
}
