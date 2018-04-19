package step24.ex5;

// 동기화 처리 전
public class Exam01 {
    public static void main(String[] args) {
        Account account = new Account("111-11-1111-111", 1000000);
        ATM gangnam = new ATM("강남", account);
        ATM seocho = new ATM("서초", account);
        ATM busan = new ATM("부산", account);
        ATM daejeon = new ATM("대전", account);
        ATM gwangju = new ATM("광주", account);
        
        gangnam.start();
        seocho.start();
        busan.start();
        daejeon.start();
        gwangju.start();
    }
}
