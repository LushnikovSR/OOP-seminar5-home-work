package units;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends BaseWarrior {

    public Monk(String name, int x, int y){
        super(name, x, y);
        setInitiative(4);
    }

    public void treat(BaseCharacter target){
        if (target.getLiveStatus() == LiveStatuses.live) {
            int points = new Random().nextInt(10, 20);
            target.addHealthPoints(points);
            System.out.println(target.getName() + " get " + points + " points of health");
        } else {
            System.out.println(target.getName() + " is " + target.getLiveStatus());
        }
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
