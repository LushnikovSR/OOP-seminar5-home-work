package units;

import java.util.ArrayList;
import java.util.Random;

public class Sorcerer extends BaseMagician {

    public Sorcerer(String name, int x, int y){
        super(name, x, y);
        setInitiative(3);
    }

    public void treat(BaseCharacter target){
        int points = new Random().nextInt(10, 20);
        target.addHealthPoints(points);
    }

    @Override
    public void step(ArrayList<BaseCharacter> enemyTeam, ArrayList<BaseCharacter> myTeam) {
        BaseCharacter foe = nearestTargetAttack(enemyTeam);
        attack(foe);
    }

    @Override
    public String getInfo() {
        return String.valueOf((this.getClass())).replaceAll("^[\\w+]+\\s[\\w+]+\\.", "") + " "
                + this.getName() + " " + "hp: " + this.getHealth();
    }
}
