package step25.ex9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import step25.ex9.Board;
import step25.ex9.BoardDao;

@Service
public class BoardService {
    @Autowired BoardDao boardDao;
    
    public void test1(Board b1, Board b2, Board b3) {
        boardDao.insert(b1);
        System.out.println("- " + b1.getNo() + "번 게시물 입력");

        boardDao.insert(b2);
        System.out.println("- " + b2.getNo() + "번 게시물 입력");
        
        boardDao.insert(b3);
        System.out.println("- " + b3.getNo() + "번 게시물 입력");
    } // 트랜잭션 관리자의 관리 대상(xml파일에서 지정)
    
    public void test2(Board b1, Board b2, Board b3) {
        boardDao.insert(b1);
        System.out.println("- " + b1.getNo() + "번 게시물 입력");

        boardDao.insert(b2);
        System.out.println("- " + b2.getNo() + "번 게시물 입력");
        
        boardDao.insert(b3);
        System.out.println("- " + b3.getNo() + "번 게시물 입력");
    }
}
