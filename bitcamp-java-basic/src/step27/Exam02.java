package step27;
// 람다
public class Exam02 {
    
    static interface Player {
        void play();
    }
    
    static void testPlayer(Player player) {
        player.play();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 메소드가 1개인 인터페이스를 람다 표현식을 사용하여 구현
        Player player1 = () -> System.out.println("RUUUUUUUUUUN");
        
        testPlayer(player1);
    }
}
