package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Board;

// 서비스 컴포넌트 - 게시물 관련 업무를 처리할 객체
public interface BoardService {
    // 메소드명은 업무에서 사용하는 용어를 사용할 것 - selectList처럼 마이바티스에서 사용하는 메소드명을 쓰는 게 아님
    public abstract List<Board> list(int pageNo, int pageSize);
    public abstract Board get(int no); // or getDetail(int no)
    public abstract int add(Board board);
    public abstract int update(Board board);
    public abstract int delete(int no);
}
