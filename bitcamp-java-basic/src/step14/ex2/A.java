package step14.ex2;

public interface A {
    public void m1();
    void m2();
    //private void m3();
    //protected void m4();
    // 호출 규칙들은 public 상태만 가능하다. 안붙여도 디폴트가 아닌 퍼블릭으로 인식된다.
}
