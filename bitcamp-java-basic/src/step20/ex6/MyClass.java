package step20.ex6;

@MyAnnotation // 필수 프로퍼티가 없는 경우, 별도로 값을 지정할 필요는 없다.
// 하지만 이건 필수 프로퍼티기때문에 값을 지정
public class MyClass {
    @MyAnnotation int i;
    @MyAnnotation public void m() {
        
    } 
    // 여기서는 Target을 Method로 지정했기때문에 메소드 앞에서만 사용할 수 있다
}
