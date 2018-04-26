package step25.ex6;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 일반 객체 전달
public class Exam02_3 {
    
    static int startIndex = 1; // 자바스크립트를 통해 받아올 부분
    static final int PAGE_SIZE = 15;
    
    public static void main(String[] args) throws Exception {
        
        InputStream inputStream = Resources.getResourceAsStream("step25/ex6/mybatis-config06.xml");
        
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        
        // Board 객체에 값을 저장하여 그 객체를 전달하기.
        // 단, 값을 꺼낼 수 있도록 프로퍼티가 있어야 한다.
        Board board = new Board();
        board.setTitle("제모옥");
        board.setContent("내요옹");
        
        int count = session.insert("BoardMapper.insertBoard", board);
        session.commit();
        System.out.println(count);
        
        // myBatis에서는 기본으로 autocommit이 false임.
        // 별도로 커밋을 해줘야하는 듯.
        
        session.close();
    }
}
