package step25.ex5;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SQL문 실행 - SqlSession 객체를 활용

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        
        // mybatis 설정 파일을 읽을 도구를 준비함.
        // => Resources의 getResourceAsStream 메소드는 인자로 설정 파일의 정보를 넘겨준다.(클래스패스에서 찾음)
        InputStream inputStream = Resources.getResourceAsStream("step25/ex5/mybatis-config.xml");
        
        // myBatis 설정 파일을 통해 builder를 사용하여 sqlSession 공장 객체 생성
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        // sqlFactory 객체로부터 session 객체를 얻어온다.
        SqlSession session = factory.openSession();
        // 여기서 에러나는 경우, mapper파일을 잘못설정했거나 설정파일(config.xml)에 문제가 있는 것이다.
        
        //session 객체를 이용하여 sql Mapper 파일에 작성한 SQL문을 실행한다.
        //
        List<Board> list = session.selectList("BoardMapper.selectBoard");
        
        for(Board board : list)
            System.out.printf("%d, %s, %s, %s\n", board.getNo(), board.getTitle(), board.getContent(), board.getRegisteredDate());
        
        System.out.println(inputStream.getClass().getName());
    }
}
