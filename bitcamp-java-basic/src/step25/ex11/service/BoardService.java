package step25.ex11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import step25.ex11.Board;
import step25.ex11.BoardDao;

@Service
public class BoardService {
    @Autowired BoardDao boardDao;
    
    //@Transactional
    public void test1(Board b1, Board b2, Board b3, Board b4, Board b5) {
        boardDao.insert(b1);
        System.out.println("- test1: " + b1.getNo() + "번 게시물 입력");

        boardDao.insert(b2);
        System.out.println("- test1: " + b2.getNo() + "번 게시물 입력");
        
        test2(b3, b4);
        
        boardDao.insert(b5);
        System.out.println("- test1: " + b5.getNo() + "번 게시물 입력");
    } // 기존 트랜잭션이 있는 상황
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void test2(Board b3, Board b4) {
        boardDao.insert(b3);
        System.out.println("-> test2: " + b3.getNo() + "번 게시물 입력");

        boardDao.insert(b4);
        System.out.println("-> test2: " + b4.getNo() + "번 게시물 입력");
    }
}
