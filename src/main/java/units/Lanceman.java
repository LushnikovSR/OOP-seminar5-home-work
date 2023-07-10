package units;

import java.util.ArrayList;

public class Lanceman extends BaseWarrior {
    public Lanceman(String name, int x, int y){
        super(name, x, y);
        setInitiative(5);
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
