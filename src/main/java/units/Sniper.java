package units;

import java.util.ArrayList;

public class Sniper extends BaseShooter {
    public Sniper(String name, int x, int y){
        super(name, x, y);
        setInitiative(1);
    }

    @Override
    public void step(ArrayList<BaseCharacter> enemyTeam, ArrayList<BaseCharacter> myTeam) {
        if (this.getHealth() == 0 || this.getArrows() == 0) {return;}
        BaseCharacter foe = nearestTargetAttack(enemyTeam);
        attack(foe);
        findPeasant(myTeam);
    }

    @Override
    public String getInfo() {
        return String.valueOf((this.getClass())).replaceAll("^[\\w+]+\\s[\\w+]+\\.", "") + " " + this.getName() + " "
                + "hp: " + this.getHealth() + " arrows: " + this.getArrows();
    }
}
