import java.util.Random;

public class Sorcerer extends BaseMagician {

    public Sorcerer(String name){
        super(name);
    }

    public void treat(BaseCharacter target){
        int points = new Random().nextInt(10, 20);
        target.addHealthPoints(points);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf((this.getClass())).replace("class ", "");
    }
}
