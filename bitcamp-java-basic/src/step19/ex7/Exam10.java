package step19.ex7;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

// IoC 컨테이너 만들기
// 객체를 저장할 때 클래스 이름으로 저장
// 객채를 꺼낼 때 클래스 이름으로 꺼내기


// 객체를 저장할 때 클래스 이름으로 저장하고 클래스 이름으로 꺼낼 수 있다.
public class Exam10 {
    int value;
    
    public Exam10() {
        this.value = 200;
    }
    
    public void print() {
        System.out.println("value : " + value);
    }
    
    public static void main(String[] args) throws Exception {
        ApplicationContext8 appContext = new ApplicationContext8("step19");
        // 클래스 객체 생성
        
        Exam10 obj = (Exam10) appContext.getBean("step19.ex7.Exam10");
        // 클래스 객체를 이용하여 그 클래스의 인스턴스를 생성한다.
        obj.print();
    }
}
