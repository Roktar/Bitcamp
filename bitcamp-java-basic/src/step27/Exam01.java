package step27;

public class Exam01 {
    
    static interface Player {
        void play();
    }
    
    static void testPlayer(Player player) {
        player.play();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 메소드가 1개인 인터페이스를 익명 클래스 문법을 사용하여 구현
        Player player1 = new Player() {
            @Override
            public void play() {
                System.out.println("RUUUUUUUUUUN");
            }
        };
        
        testPlayer(player1);
        
    }
}
