package step25.ex8;

import java.util.List;

// 데이터를 처리하는 코드를 별도의 클래스로 캡슐화
public interface BoardDao {
    List<Board> selectList();
    int insert(Board board);
}
