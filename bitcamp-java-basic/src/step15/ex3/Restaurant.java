package step15.ex3;

public class Restaurant extends Building {

    @Override
    public void startEffect() {
        // TODO Auto-generated method stub
        System.out.println("조리중..");
    }

    @Override
    public void endEffect() {
        // TODO Auto-generated method stub
        System.out.println("조리끝");
    }
}
