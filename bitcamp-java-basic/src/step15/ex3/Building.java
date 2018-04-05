package step15.ex3;

public abstract class Building {
    public void build() {
        System.out.println("건설 시작");
        startEffect();
        System.out.println("건설 완료");
        endEffect();
    }
    
    
    // 아직 어떻게 수행할 것인지를 정하지 않았다.
    // 추상메소드를 사용하여 템플릿 메소드를 선언
    // 서브클래스들은 이 메소드를 그대로 상속받기때문에 재정의하지않는 이상
    // 사용할 수 없다.
    public abstract void startEffect();
    public abstract void endEffect();
}
