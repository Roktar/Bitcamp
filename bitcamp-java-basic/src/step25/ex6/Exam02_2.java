package step25.ex6;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// - 쓰면 안되지만 우선 알아둘 것
// SQL문을 만들어서 전달
public class Exam02_2 {
    
    static int startIndex = 1; // 자바스크립트를 통해 받아올 부분
    static final int PAGE_SIZE = 15;
    
    public static void main(String[] args) throws Exception {
        
        InputStream inputStream = Resources.getResourceAsStream("step25/ex6/mybatis-config05.xml");
        
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        
        // SQL 실행할 때 파라미터 값을 전달한다면 두 번째 매개변수로 전달해야한다.
        // 여러개의 값을 전달한다면 Map 객체에 담아서 전달할 것.
        
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("limitSQL", "limit 9, 3");
        // SQL Injection 공격에 취약하므로 사용해서는 안된다.
        
        List<Board> list = session.selectList("BoardMapper.selectBoard", paramMap);
        
        for(Board board : list)
            System.out.printf("%d, %s, %s, %s\n", board.getNo(), board.getTitle(), board.getContent(), board.getRegisteredDate());
    }
}
