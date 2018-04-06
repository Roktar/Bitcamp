package step19.ex9;

@Component(value = "engine")
public class Engine {  
    public Engine() {
        System.out.println("엔진 생성");
    }
    public void run() {
        System.out.println("엔진 가동");
    }
}
