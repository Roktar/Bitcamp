package step11.ex11;

public class C2 extends C {
    // C의 메소드를 오버라이딩한 것이 아님
    // why? C의 m1은 private 설정이 되어있어서 상속받아도 사용할 수 없다.
    // 여기서 m1은 그저 C2의 m1일 뿐이다.
    //@Override
    private void m1() {

    } // 이것은 override가 불가능하다.(접근불가로)
    
/*    @Override
    protected void m2() {

    }
    
    @Override
    void m3() {

    }
    
    @Override
    public void m4() {

    }*/
    
    //@Override void m2() { } // 컴파일 에러
    // 부모클래스의 메소드보다 접근범위를 확대할 수는 있으나 좁힐 수는 없다.
    // public > protected > default > private ?
    @Override public void m2() { }
    
    //@Override protected void m3() { }
    @Override public void m3() { }
    
}
