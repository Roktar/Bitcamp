package step25.ex6;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Select와 ResultType

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        
        InputStream inputStream = Resources.getResourceAsStream("step25/ex6/mybatis-config01.xml");
        
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        
        // boardMapper 파일의 namespace.<SQL:ID> 로 실행한다.
        List<Board> list = session.selectList("BoardMapper.selectBoard");
        
        for(Board board : list)
            System.out.printf("%d, %s, %s, %s\n", board.getNo(), board.getTitle(), board.getContent(), board.getRegisteredDate());
        
        //boardMapper01 에러
        //why? 컬럼명기준으로 setter함수를 찾는데 자바는 db 속성명과 다른 이름으로 사용하고있다.
        //그래서 setter를 찾지 못해서 setter메소드를 못써서 값을 채워넣을 수가 없음.
        //컬럼명 기준의 프로퍼티를 찾지 못했기때문이다. (프로퍼티는 getter, setter를 통틀어서 말하는 거임)
        
        System.out.println(inputStream.getClass().getName());
    }
}
