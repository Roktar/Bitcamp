package step19.ex6;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 6) 클래스 객체를 이용하여 인스턴스를 만든 후 저장


// 클래스 이름으로 해당 클래스를 로딩한 후, 클래스 객체를 가지고온다.
// 클래스 객체가 있으면 언제든지 인스턴스를 생성할 수 있다!
public class Exam09 {
    public static void main(String[] args) throws Exception {

        ApplicationContext7 appContext = new ApplicationContext7("step19");
        
        List<Object> objects = appContext.getObjects();
        
        for(Object f : objects) 
                System.out.printf("%s\n", f.getClass().getName());
    }
}
