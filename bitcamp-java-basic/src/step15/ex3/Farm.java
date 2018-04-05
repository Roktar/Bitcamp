package step15.ex3;

public class Farm extends Building {
    @Override
    public void startEffect() {
        // TODO Auto-generated method stub
        System.out.println("땅을 고른다");
    }

    @Override
    public void endEffect() {
        // TODO Auto-generated method stub
        System.out.println("씨앗을 뿌린다");
    }
}
