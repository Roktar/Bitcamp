package step22.ex9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
// transient
public class Exam04_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_5.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);
                
        Score s = (Score) in.readObject();
        // readObject를 통해 객체를 만들고 그 객체에 데이터를 담아서 s에 전달한다.
        // 하지만 실행결과를 보면 생성자 호출이 되지 않았다는 점을 볼 수 있다.

        in.close();
        System.out.println(s);
        
        s.compute();
        System.out.println(s);
    }
}
