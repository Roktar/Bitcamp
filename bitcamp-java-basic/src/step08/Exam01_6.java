package step08;

public class Exam01_6 {
    static class Member {
        final static int GUEST = 0;
        final static int MEMBER = 1;
        final static int MANAGER = 2;
        
        String id;
        String pw;
        int type; // 0 : 손님, 1: 일반, 2: 관리자
    }

    public static void main(String[] args) {
        Member m1 = new Member();
        m1.id = "aa";
        m1.pw = "1111";
        m1.type = 0;
        
        Member m2 = new Member();
        m2.id = "bb";
        m2.pw = "1111";
        m2.type = 2;
        
        Member m3 = new Member();
        m3.id="cc";
        m3.pw="111";
        m3.type = 1;
        
        // 상수 : 의미있는 이름으로 변수를 만들어놓고 활용하는 것.
        
        Member m4 = new Member();
        m1.id = "aa";
        m1.pw = "1111";
        m1.type = Member.GUEST;
        
        Member m5 = new Member();
        m2.id = "bb";
        m2.pw = "1111";
        m2.type = Member.MANAGER;
        
        Member m6 = new Member();
        m3.id="cc";
        m3.pw="111";
        m3.type = Member.MEMBER;
        
    }
}
