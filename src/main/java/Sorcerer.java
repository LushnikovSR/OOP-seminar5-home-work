import java.util.Random;

public class Sorcerer extends BaseMagician {

    public Sorcerer(String name){
        super(name);
    }

    public void treat(BaseCharacter target){
        int points = new Random().nextInt(10, 20);
        target.addHealthPoints(points);
    }
}
