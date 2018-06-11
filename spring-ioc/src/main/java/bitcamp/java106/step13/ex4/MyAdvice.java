package bitcamp.java106.step13.ex4;

public class MyAdvice {

    // 타겟 객체의 메소드를 호출하기 전, 그 메소드가 받을 파라미터를 선수쳐서 받기
    // 기본적으로 변수 이름은 xml 파일에서 설정했던 이름과 동일해야한다.
    public void doBefore(int a, int b) {
        System.out.printf("MyAdvice.doBefore() : %d, %d\n", a, b);
    }
    public void doAfter() {
        System.out.println("MyAdvice.doAfter()");
    }
    // 타겟 객체의 메소드를 실행한 후 그 결과를 받기
    public void doAfterReturning(Object returnValue) {
        System.out.println("MyAdvice.doAfterReturning() : " + returnValue);
    }
    // 예외발생 시 예외객체 받기
    public void doAfterThrowing(Exception error) {
        System.out.println("MyAdvice.doAfterThrowing()" + error.getMessage());
    }
}
