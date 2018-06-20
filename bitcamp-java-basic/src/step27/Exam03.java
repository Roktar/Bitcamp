package step27;

// 아규먼트로 람다 쓰기
public class Exam03 {
    
    static interface Player {
        void play();
    }
    
    static void testPlayer(Player player) {
        player.play();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 메소드가 1개인 인터페이스를 람다 표현식을 사용하여 구현
        
        testPlayer(new Player() {
            @Override
            public void play() {
                System.out.println("RUUUUUUUUUUN");
            }
        });
        
        testPlayer( ()->System.out.println("실행") );
    }
}
