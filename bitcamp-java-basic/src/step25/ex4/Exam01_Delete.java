package step25.ex4;

import java.util.Scanner;

// JDBC 코드를 별도의 클래스로 캡슐화(DAO 적용)
public class Exam01_Delete {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("삭제할 게시물 번호? ");
        String no = sc.nextLine();
        
        try {
            DataSource dataSource = new DefaultDataSource();
            BoardDao boardDao = new BoardDao(dataSource);
            int c = boardDao.delete(Integer.parseInt(no));
            System.out.printf("%d개 삭제완료", c);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
